package com.qcby.springboottest.controller;

import com.qcby.springboottest.model.Person;
import com.qcby.springboottest.model.ResponseResult;
import com.qcby.springboottest.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/person")
@Api(tags = {"用户信息接口"})
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/findAll")
    @ResponseBody
    @ApiOperation(value = "查询所有用户信息")
    public ResponseResult findAll(){
        List<Person> personList = personService.findAll();
        System.out.println(personList.toString());
        return new ResponseResult(200,"success",personList);
    }

    @RequestMapping("/login")
    @ResponseBody
    @ApiOperation(value = "登录")
    public ResponseResult login(Person person){
        List<Person> personList = personService.login(person);
        System.out.println(personList.toString());
        if(personList.size() == 1){
            return new ResponseResult(200,"登录成功");
        }else {
            return new ResponseResult(999,"登录失败");
        }
    }

}
