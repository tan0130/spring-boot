package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by tan on 2018/6/12
 * 用户操作控制层实现
 **/
@RestController // 是@ResponserBody 和 @Controller的合集
//@Controller
@RequestMapping("/user")
public class UserController {

    // 采用构造方法注入UserService
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public User getUserById(int id) {
        System.out.println("查询用户信息");
        User user = userService.findUserById(id);
        System.out.println("userService:" + userService);
        return user;
    }

    /**
     * 添加用户信息
     * */
    @RequestMapping(value = "/addUser")
    public void addUser(User user) {
        user.setName("张三四");
        user.setPassword("123456");
        user.setAge(23);
        user.setSex("女");
        userService.save(user);
    }

    /**
     * 根据姓名查找用户信息
     * */
    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
    public User getUserByName(String name) {
        User user = null;
        try {
            user = userService.findUserByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 根据id删除用户信息
     * */
    @RequestMapping(value = "/deleteUserById")
    public void deleteUserById(int id) {
        try {
            userService.deleteUserById(id);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试页面跳转
     * */
    @RequestMapping(value = "/toPage")
    public String toPage() {
        return "html/hello";
    }
}
