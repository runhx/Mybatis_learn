package com.zhu.dao;

import com.zhu.pojo.User;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart @create 2021-06-15 23:36
 */
public class UserMapperTest {
    @Test
    public void test(){
        //1. 获得sqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行SQL(方式一)
        UserMapper userdao = sqlSession.getMapper(UserMapper.class);//getMapper 获取User接口的方法
        List<User> userList = userdao.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void  getUserById(){
        //获取
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);

        //关闭
        sqlSession.close();

    }

    //增删改需要提交事务
    @Test
    public void addUser(){
        //获取
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int adding = mapper.addUser(new User(5, "梨花", "1597553"));

        if(adding>0){
            //提交事务
            System.out.println("注册成功~!");
            //提交事务
            sqlSession.commit();
        }else {
            System.out.println("插入失败~!");
        }
        //关闭
        sqlSession.close();

    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //要与Usermapper 一一对应
        mapper.updateUser(new User(5, "黄鸿磊", "000000"));
        System.out.println("修改成功");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);

        sqlSession.commit();
        sqlSession.close();
    }

    //万能Map
    //添加用户
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userId",6);
        map.put("userName","huhuhu");
        map.put("pwd","123456");
        mapper.addUser2(map);
        sqlSession.close();
    }

    //查询用户
    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("id",1);

        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2);
        sqlSession.close();
    }
//关于SQL注入=================
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserLike("%黄鸿%");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

}