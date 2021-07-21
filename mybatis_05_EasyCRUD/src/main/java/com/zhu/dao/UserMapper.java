package com.zhu.dao;

import com.zhu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart @create 2021-06-15 22:19
 */
public interface UserMapper {

    //方法存在多个参数,每个参部都要添加@Param("")
    @Select("select * from mybatis.user ")
    List<User> gertUser();

    @Select("select * from mybatis.user where id = #{id}")
    List<User> gertUserbyid(@Param("id") int id);

    //adduser
    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);

    //修改
    @Update("Update user set name=#{name} , pwd=#{password} where id = #{id}")
    int updateUser(User user);

    //删除
    @Delete("delete from user where id =#{uid}")
    int deleteUser( @Param("uid") int id);
}
