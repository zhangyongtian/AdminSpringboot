package com.zhang.biyeseji.remeberme.config;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisCache implements Cache {
    private String id;

    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;

    }

    @Override
    public void putObject(Object o, Object o1) {
        RedisTemplate redisTemplate= (RedisTemplate) ShiroGetApplication.getmYapplicationContext().getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForHash().put(this.id,o.toString(),o1);
    }

    @Override
    public Object getObject(Object o) {
        RedisTemplate redisTemplate= (RedisTemplate) ShiroGetApplication.getmYapplicationContext().getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate.opsForHash().get(this.id,o.toString());
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {
        RedisTemplate redisTemplate= (RedisTemplate) ShiroGetApplication.getmYapplicationContext().getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.delete(this.id);
    }

    @Override
    public int getSize() {
        return 0;
    }
}
