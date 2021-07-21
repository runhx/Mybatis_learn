package com.zhu.dao;

import com.zhu.pojo.User;

import java.util.List;

/**
 * @author shkstart @create 2021-06-15 22:19
 */
public interface UserMapper {
     //根据id查询用户
    User getUserById(int id);
}
