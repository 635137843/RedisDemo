package com.hmx.redistest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmx.redistest.pojo.User;
import com.hmx.redistest.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")//使用自己封装的模板
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test(){
        redisUtil.set("name","hmx");
        System.out.println(redisUtil.get("name"));
    }

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
