package dao;

import com.zhu.dao.UserMapper;
import com.zhu.pojo.User;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author shkstart @create 2021-06-15 23:36
 */
public class UserMapperTest {
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
}