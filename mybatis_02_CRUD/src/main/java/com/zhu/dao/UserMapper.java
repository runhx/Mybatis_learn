package com.zhu.dao;
import com.zhu.pojo.User;
import java.util.List;

/**
 * @author shkstart @create 2021-06-15 22:19
 */
public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //增加用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);
}
