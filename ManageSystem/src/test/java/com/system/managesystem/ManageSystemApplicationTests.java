package com.system.managesystem;

import com.system.managesystem.pojo.User;
import com.system.managesystem.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManageSystemApplicationTests {
    @Autowired
    UserServiceImpl userService;
    @Test
    void contextLoads() {
    }
    @Test
    void insertTest(){
        User newUser=new User();
        newUser.setName("于小雪");
        newUser.setNo("鬼谷术士1");
        newUser.setAge(18);
        newUser.setSex(2);
        newUser.setPhone("1322");
        newUser.setRoleId(2);
        newUser.setPassword("112233");
        newUser.setIsValid("Y");
        userService.save(newUser);
    }
}
