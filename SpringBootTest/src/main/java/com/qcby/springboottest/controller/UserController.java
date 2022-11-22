package com.qcby.springboottest.controller;


import com.qcby.springboottest.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/user")  // 一级目录
public class UserController {

    /**
     * post请求接收单个数据
     * @param name
     * @return
     */
  //  @PostMapping("/getName")  //这是post请求
    @RequestMapping(value = "/getName",method = RequestMethod.POST)  //这是post请求
    @ResponseBody
    public String getName(String name){
        System.out.println(name);
        return "hello";
    }

    /**
     *  post请求接收多个数据
     * @param name
     * @param age
     * @return
     */
    @PostMapping("/getNameAndAge")
    @ResponseBody
    public String getNameAndAge(String name,Integer age){
        System.out.println(name +  " " + age);
        return "hello";
    }

    @PostMapping("/user")
    @ResponseBody
    public String findUser(@RequestBody User user){
        System.out.println(user.toString());
        return "hello";
    }


    @PostMapping("/users")
    @ResponseBody
    public String findListUser(@RequestBody List<User> users){
        System.out.println(users.toString());
        return "hello";
    }



}
