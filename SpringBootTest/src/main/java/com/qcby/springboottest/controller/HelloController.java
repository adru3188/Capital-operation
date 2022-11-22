package com.qcby.springboottest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Api(tags = {"第一个页面"})
public class HelloController {

    @RequestMapping("/index")  //指得是访问地址
    @ApiOperation("首次实践")
    @ResponseBody
    public String getHello(){
        return "hello world";
    }





}
