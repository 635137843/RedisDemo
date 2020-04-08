package com.hmx.redistest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmx.redistest.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() throws JsonProcessingException {
        //连接对象
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();

        //redisTemplate.opsForValue().set("mykey","何明鑫");
        //System.out.println(redisTemplate.opsForValue().get("mykey"));
        User user = new User("何明鑫", 24);
        String s = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",s);
        System.out.println(redisTemplate.opsForValue().get("user"));

    }

}
