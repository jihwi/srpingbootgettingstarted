package com.jihwi.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Optional;

//@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisRepository redisRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ValueOperations<String, String> value = redisTemplate.opsForValue();
        value.set("keesun", "whiteship");
        value.set("springboot", "2.0");
        value.set("hello", "world");

        Redis redis = new Redis();
        redis.setName("jihwi");
        redis.setEmail("jihwi@cj.net");

        redisRepository.save(redis);
        Optional<Redis> byId = redisRepository.findById(redis.getId());
        byId.ifPresent(System.out::println);

    }
}
