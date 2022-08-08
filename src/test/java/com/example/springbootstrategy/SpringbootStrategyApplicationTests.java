package com.example.springbootstrategy;

import com.example.springbootstrategy.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootStrategyApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void testUser(){
        User user = User.builder().name("my_name").password("my_password").build();
        System.out.println(user);
    }

}
