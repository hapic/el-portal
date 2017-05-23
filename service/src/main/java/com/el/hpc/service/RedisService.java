package com.el.hpc.service;

import com.el.hpc.dao.RedisCmd;
import com.el.hpc.templet.RedisCmdTemplet;
import com.el.hpc.vo.RedisResultVo;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
public class RedisService implements InvocationHandler,IRedisService {



    @Override
    public String get(RedisResultVo vo,Jedis jedis){
        return jedis.get(vo.getKey());
    }

    public String ttl(RedisResultVo vo,Jedis jedis){
        return jedis.ttl(vo.getKey()).toString();
    }

    public String exists(RedisResultVo vo,Jedis jedis){
        return jedis.exists(vo.getKey()).toString();
    }


    @Override
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



    }
}
