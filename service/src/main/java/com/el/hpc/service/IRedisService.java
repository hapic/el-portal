package com.el.hpc.service;

import com.el.hpc.vo.RedisResultVo;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/5/23.
 */
public interface IRedisService {

    public String get(RedisResultVo vo,Jedis jedis);

    public String ttl(RedisResultVo vo,Jedis jedis);

    public String exists(RedisResultVo vo,Jedis jedis);
}
