package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by tan on 2018/6/12
 * 用户操作控制层实现
 **/
@RestController
@RequestMapping("/user")
@Qualifier("userRepository")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public User getUserById(int id) {
        System.out.println("查询用户信息");
        User user = userRepository.findUserById(id);
        System.out.println("userRepository:" + userRepository);
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
        userRepository.save(user);
    }
}
