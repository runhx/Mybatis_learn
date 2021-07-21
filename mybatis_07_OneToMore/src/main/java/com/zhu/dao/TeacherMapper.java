package com.zhu.dao;

import com.zhu.pojo.Student;
import com.zhu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shkstart @create 2021-06-27 17:16
 */
public interface TeacherMapper {
    List<Teacher> getTeacher();

    Teacher GetTeacher(@Param("tid") int id);
    Teacher GetTeacher2(@Param("tid") int id);
}
