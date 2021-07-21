package com.zhu.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author shkstart @create 2021-06-28 16:39
 */
public class IDUtils {

    //当数据库表中,比如删除了一位客户,等下次在注册用户时会在注销的用户的id+1
    //企业中一般会用UUID,为了保证其唯一
    //获取随机ID
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    @Test
    public void testID(){
        System.out.println(IDUtils.getID());
        System.out.println(IDUtils.getID());
        System.out.println(IDUtils.getID());
    }
}
