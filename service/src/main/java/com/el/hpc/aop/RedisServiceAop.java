package com.el.hpc.aop;

import com.el.hpc.service.JedisUtil;
import com.el.hpc.vo.RedisResultVo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

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
 * @Date : 2017/5/24 9:03
 * 访问redis的aop
 */
@Aspect
@Configuration
public class RedisServiceAop {

    @Around(value = "execution(* com.el.hpc.service.RedisService.*(..))")
    public Object twiceAsOld(ProceedingJoinPoint thisJoinPoint){

        System.err.println ("切面执行了。。。。");
        Jedis jedis = null;
        String errroMsg="";
        try {
            Object[] args = thisJoinPoint.getArgs();
            long begin = System.currentTimeMillis();

            RedisResultVo vo=(RedisResultVo)args[0];
            jedis = JedisUtil.borrowJedis(vo);
            args[1]=jedis;
            Object proceed = thisJoinPoint.proceed(args);
            long end = System.currentTimeMillis();
            vo.setWasteTime((int)(end-begin));
            return proceed;
        } catch (Throwable e) {
            e.printStackTrace ();
            errroMsg=e.getMessage();
        }finally {
            if(jedis!=null && jedis.isConnected()){
                jedis.close();
            }
        }
        return "<error message> "+errroMsg;
    }
}
