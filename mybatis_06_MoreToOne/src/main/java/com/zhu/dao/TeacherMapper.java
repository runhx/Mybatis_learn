package com.zhu.dao;

import com.zhu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author shkstart @create 2021-06-20 21:47
 */
public interface TeacherMapper {
    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacher (@Param("tid") int id);
}
