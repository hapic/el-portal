package com.el.hpc.controller.manager;

import com.el.hpc.service.IRedisService;
import com.el.hpc.service.RedisService;
import com.el.hpc.vo.RedisResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 *
 * @User : Hapic
 * @Date : 2017/5/23 13:21
 * 操作redis的Controller
 */
@Controller
@RequestMapping("/manager/redis")
public class RedisController {


    @Autowired
    private RedisService redisService;

    @RequestMapping("page")
    public ModelAndView page() {
        return new ModelAndView("manager/redis");
    }

    @RequestMapping("do")
    @ResponseBody
    public RedisResultVo doCmd(RedisResultVo vo){
        if("get".equals(vo.getCmd())){
            String value = redisService.get(vo, null);
            if(value==null){
                value="查询不到";
            }
            vo.addValue("Key: "+vo.getKey(),"Value: "+value);

        }else if("ttl".equals(vo.getCmd())){
            String ttl = redisService.ttl(vo, null);
            if("-2".equals(ttl)){
                ttl="key不存在";
            }else if("-1".equals(ttl)){
                ttl="没有设置过期时间";
            }
            vo.addValue(ttl);
        }else if("exists".equals(vo.getCmd())){
            String exists = redisService.exists(vo, null);
            if("true".equals(exists)){
                exists="存在";
            }else
                exists="不存在";
            vo.addValue(exists);
        }else if("type".equals(vo.getCmd())){
            String type = redisService.type(vo, null);
            if(type==null){
                type="不存在";
            }
            vo.addValue(type);
        }else if("set".equals(vo.getCmd())){
            /*String type=null;
            if(vo.getValueStr()==null || vo.getValueStr().equals("")){

            }else {
                type= redisService.set(vo, null);
            }
            if(type==null){
                type="不存在";
            }*/

            vo.addValue("暂不支持");
        }else if("hget".equals(vo.getCmd())){
            String type = redisService.type(vo, null);
            if(!"hash".equals(type)){
                vo.addValue("类型不一致");
                return vo;
            }

            List<String> hmget = redisService.hmget(vo, null);
            String field = vo.getField();
            String[] fields = field.split(",");

            for(int i=0;i<fields.length && i<hmget.size();i++){
                vo.addValue("Field: "+fields[i],"Value: "+hmget.get(i));
            }
        }else if("hset".equals(vo.getCmd())){
            /*String type = redisService.type(vo, null);
            if(!"hash".equals(type)){
                vo.addValue("类型不一致");
                return vo;
            }

            Long hset = redisService.hset(vo, null);
            String result="";
            if("1".equals(hset)){
                result="设置成功!";
            }else if("2".equals(hset)){
                result="覆盖成功!";
            }else
                result="失败!";
            vo.addValue(result);*/
            vo.addValue("暂不支持");
        }else if("hlen".equals(vo.getCmd())){
            String type = redisService.type(vo, null);
            if(!"hash".equals(type)){
                vo.addValue("类型不一致");
                return vo;
            }
            Long hset = redisService.hlen(vo, null);
            vo.addValue(hset+"");
        }else if("llen".equals(vo.getCmd())){
            String type = redisService.type(vo, null);
            if(!"list".equals(type)){
                vo.addValue("类型不一致");
                return vo;
            }

            Long hset = redisService.llen(vo, null);
            vo.addValue(hset+"");
        }else if("zrange".equals(vo.getCmd())){
            String type = redisService.type(vo, null);
            if(!"zset".equals(type)){
                vo.addValue("类型不一致");
                return vo;
            }

            Set<Tuple> zrange = redisService.zrange(vo, null);
            for(Tuple tuple :zrange){
                vo.addValue("Value: "+tuple.getElement(),"Scores: "+tuple.getScore());
            }
        }else if("sismember".equals(vo.getCmd())){
            String type = redisService.type(vo, null);
            if(!"set".equals(type)){
                vo.addValue("类型不一致");
                return vo;
            }

            boolean sismember = redisService.sismember(vo, null);

            vo.addValue(sismember+"");
        }else if("scan".equals(vo.getCmd())){
            long start = System.currentTimeMillis();
            List<String> keys= new ArrayList<>();
            String nextCursor="";
            while (!"0".equals(nextCursor) && vo.size()<vo.getCount()){
                nextCursor=redisService.scan(vo, null);
                vo.setCursor(Integer.parseInt(nextCursor));
            }

            long end = System.currentTimeMillis();

            vo.setWasteTime((int) (end-start));

            if(!"0".equals(nextCursor)){
                vo.addValue("nextCursor",nextCursor);
            }
            if(vo.size()<1){
                vo.addValue("查无结果!","-");
            }

        }else if("ping".equals(vo.getCmd())){
            String result=redisService.ping(vo, null);
            vo.addValue(result);
        }

        return vo;
    }



}
