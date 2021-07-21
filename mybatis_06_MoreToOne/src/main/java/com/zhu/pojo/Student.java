package com.zhu.pojo;

import lombok.Data;

/**
 * @author shkstart @create 2021-06-20 21:43
 */
@Data
public class Student {
    private int id;
    private String name;
    private Teacher teacher;
}
