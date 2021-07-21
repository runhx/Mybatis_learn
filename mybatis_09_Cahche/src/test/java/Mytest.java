import com.zhu.dao.UserMapper;
import com.zhu.pojo.User;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author shkstart @create 2021-06-29 22:15
 */
public class Mytest {
    @Test
    public void getUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUser(2);
        System.out.println(user);
        sqlSession.close();
    }
}
