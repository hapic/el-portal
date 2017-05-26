package com.el.hpc.service;

import com.el.hpc.dao.RedisCmd;
import com.el.hpc.templet.RedisCmdTemplet;
import com.el.hpc.vo.RedisResultVo;
import org.springframework.stereotype.Service;
import redis.clients.jedis.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
 * @Date : 2017/5/23 16:31
 * redis的查询借口
 */
@Service
public class RedisService  {



    public List<String> get(RedisResultVo vo,Jedis jedis){
        List<String> valuesList=new ArrayList<>();

        String key = vo.getKey();
        String[] split = key.split(",");

        if(split.length>1){
            List<String> mget = jedis.mget(split);
            valuesList.addAll(mget);
        }
        String s = jedis.get(vo.getKey());
        valuesList.add(s);
        return valuesList;
    }

    public String ttl(RedisResultVo vo,Jedis jedis){
        return jedis.ttl(vo.getKey()).toString();
    }

    public String exists(RedisResultVo vo,Jedis jedis){
        return jedis.exists(vo.getKey()).toString();
    }

    public String type(RedisResultVo vo,Jedis jedis){
        return jedis.type(vo.getKey()).toString();
    }

    public String set(RedisResultVo vo, Jedis jedis) {
        return jedis.set(vo.getKey(),vo.getValueStr());
    }

    public List<String> hmget(RedisResultVo vo, Jedis jedis) {
        String[] fields = vo.getField().split(",");

        List<String> list= new ArrayList<String>();

        if(fields.length<=1){


            String hget = jedis.hget(vo.getKey(), vo.getField());
            list.add(hget);
            return  list;
        }
        try {
            List<String> hmget = jedis.hmget(vo.getKey(), fields);
            list.addAll(hmget);
        } catch (Exception e) {
            e.printStackTrace();
            list.add(e.getMessage());
        }
        return list;
    }

    public Long hset(RedisResultVo vo,Jedis jedis){
        return jedis.hset(vo.getKey(), vo.getField(), vo.getValueStr());
    }

    public Long hlen(RedisResultVo vo,Jedis jedis){
        return jedis.hlen(vo.getKey());
    }
    public Long llen(RedisResultVo vo,Jedis jedis){
        return jedis.llen(vo.getKey());
    }

    public Set<Tuple> zrange(RedisResultVo vo,Jedis jedis){
        return jedis.zrangeWithScores(vo.getKey(), vo.getStart(), vo.getEnd());
    }

    public boolean sismember(RedisResultVo vo,Jedis jedis){
        return jedis.sismember(vo.getKey(),vo.getField());
    }

    public String scan(RedisResultVo vo, Jedis jedis) {
        ScanParams params= new ScanParams();
        params.match(vo.getKey());
        params.count(vo.getCount());
        ScanResult<String> scan = jedis.scan(vo.getCursor() + "", params);
        String stringCursor = scan.getStringCursor();
        List<String> result = scan.getResult();
        for(String key :result){
            vo.addValue(key,"-");
        }

        return stringCursor;

    }

    public String ping(RedisResultVo vo,Jedis jedis){
        return jedis.ping();
    }


    /*@Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ((args == null) || (args.length <= 0)) {
            return null;
        }
        RedisResultVo vo=(RedisResultVo)args[0];

        Jedis jedis = null;
        String errroMsg="";
        try {

            jedis = JedisUtil.borrowJedis(vo);
            args[1]=jedis;
            return method.invoke(this,args);
        } catch (Exception e) {
            e.printStackTrace();
            errroMsg=e.getMessage();
        }finally {
            if(jedis!=null && jedis.isConnected()){
                jedis.close();
            }
        }

        return "<error message> "+errroMsg;
    }

    public static void main(String[] args) {

        IRedisService o = (IRedisService)Proxy.newProxyInstance(IRedisService.class.getClassLoader(), new Class[]{IRedisService.class}, new RedisService());
        RedisResultVo vo= new RedisResultVo();
        vo.setIp("192.168.2.12");
        vo.setPort("6380");
        vo.setDb("0");
        vo.setCmd("get");
        vo.setKey("ddd");
        String s = o.get(vo,null);
        System.out.println(s);



    }*/
}
