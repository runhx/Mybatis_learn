package com.zhu.dao;
import com.zhu.pojo.Student;
import java.util.List;

/**
 * @author shkstart @create 2021-06-20 21:46
 */
public interface StudentMapper {
//    查询所有的学生信息,以及对应的老师的信息
    public List<Student> getStudent();

    public List<Student> getStudent2();

}
