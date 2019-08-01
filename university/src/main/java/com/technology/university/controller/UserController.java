package com.technology.university.controller;

import com.technology.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/selectAllUser")
    public Map<String, Object> selectAllUser(@RequestBody Map<String, Object> requestMap){
        String name = requestMap.get("name").toString();
        Integer pageNumber = Integer.parseInt(requestMap.get("pageNumber").toString());
        Integer currentPage = Integer.parseInt(requestMap.get("currentPage").toString());
        Map<String, Object> map = userService.selectAllUser(name,pageNumber,currentPage);
        map.put("code","0000");
        map.put("msg","请求成功");
        return map;
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @CrossOrigin
    public Map<String, Object> test(){
        Map<String, Object> map= new HashMap<>();
        map.put("code","0000");
        map.put("msg","请求成功");
        return map;
    }
}
