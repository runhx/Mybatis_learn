package com.zhu.pojo;
import lombok.Data;
import java.util.List;
/**
 * @author shkstart @create 2021-06-27 17:16
 */
@Data
public class Teacher {
    private String name;
    private int id;
    private List<Student> students;
}
