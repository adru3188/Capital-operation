package com.qcby.springboottest;

import com.qcby.springboottest.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest  //标明这是项目的测试文件
public class UserTest {

    //最传统的方式


    @Autowired
    private User SpringUser;

    @Test
    void SpringDemoTest(){
        System.out.println(SpringUser.toString());
    }

    // 控制权翻转   + 依赖注入
    // 如何创建对象：new对象


}
