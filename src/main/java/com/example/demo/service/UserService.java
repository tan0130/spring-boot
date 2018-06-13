package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 * create by tan on 2018/6/13
 * 业务逻辑层
 **/
@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 根据id查找用户信息
     * @param id 接收用户id
     * @return user 返回一个用户实体
     * */
    public User findUserById(int id) {
        User user = null;
        try {
            user = userRepository.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 添加用户信息
     * @param
     * */
    public void save(User user) {
        userRepository.save(user);
    }

    /**
     * 根据姓名查找用户信息
     * @param name 接收一个用户姓名
     * @return user 返回查询到的结果
     * */
    public User findUserByName(@Param("name") String name) {
        return userRepository.findUserByName(name);
    }

    /**
     * 根据id删除用户信息
     * @param id 接收用户编号
     * */
    public void deleteUserById(@Param("id") int id) {
       userRepository.deleteUserById(id);
    }
}
