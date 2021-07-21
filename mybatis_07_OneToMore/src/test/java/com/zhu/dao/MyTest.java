package com.zhu.dao;
import com.zhu.pojo.Teacher;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
//    <!--  按结果嵌套查询-->
    public void getTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.GetTeacher(1);
        System.out.println(teacher);
        /*
        Teacher
        name=秦老师, id=1
        students
        Student(id=1, name=小明, tid=1)
        Student(id=2, name=小红, tid=1)
        Student(id=3, name=小张, tid=1)
        Student(id=4, name=小李, tid=1)
        Student(id=5, name=小王, tid=1)
        */
        sqlSession.close();

    }

    @Test
//    <!--    先查询老师,再查学生-->
    public void getTeacher2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.GetTeacher2(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}
