package dao;

import com.zhu.dao.UserMapper;
import com.zhu.pojo.User;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author shkstart @create 2021-06-19 19:58
 */
public class UserMapperTest {
    @Test
    //用注解查询所有
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //底层主要用的是反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users= mapper.gertUser();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    //用注解通过id查询
    //用注解取数据的时候 需要用@Param("id") 对应数据 去取
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.gertUserbyid(1);
        System.out.println(users);

        sqlSession.close();
    }
/*    @Test
//增加
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(7, "hello", "12345631"));
        sqlSession.close();
    }

    @Test
//修改
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(6,"小黄","123456"));

        sqlSession.close();
    }
*/
    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(2);
        System.out.println("删除成功");
        sqlSession.close();
    }
}
