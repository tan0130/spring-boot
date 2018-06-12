package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * create by tan on 2018/6/12
 * 用户操作Repository
 **/
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * 根据id查找用户信息
     * @param id 接收用户id
     * @return user 返回一个用户实体
     * */
    public User findUserById(int id);

    /**
     * 添加用户信息
     * @param u 接收用户输入信息
     * */
    public User save(User u);

    /**
     * 根据姓名查找用户信息
     * @param name 接收一个用户姓名
     * @return user 返回查询到的结果
     * */
    @Query("select t from User t where t.name=:name")
    public User findUserByName(@Param("name") String name);
}
