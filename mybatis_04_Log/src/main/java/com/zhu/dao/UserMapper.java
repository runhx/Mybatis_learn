package com.zhu.dao;
import com.zhu.pojo.User;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart @create 2021-06-15 22:19
 */
public interface UserMapper {
     //根据id查询用户
    User getUserById(int id);

    //分页实现 查询
    List<User> getUsersbylimit(Map<String,Integer> map);
}
