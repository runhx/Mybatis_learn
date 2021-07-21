package com.zhu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author shkstart @create 2021-06-15 18:01
 */
//工具类
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //官方文件硬性要求的写法
            //使用Mybatis f获取SqlSessionFactory 对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //既然有了 SqlSessionFactory 我们可以从中获 得 SqlSessionFactory 实例
    //SqlSessionFactory 完全包含了面向数据库 执行SQL 的所有方法
    //sqlSession== Connection

    public static SqlSession getSqlSession(){

//        return  sqlSessionFactory.openSession();
      return  sqlSessionFactory.openSession(true);  //自动提交事务

    }
}
