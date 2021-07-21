package dao;

import com.zhu.dao.UserMapper;
import com.zhu.pojo.User;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


/**
 * @author shkstart @create 2021-06-15 23:36
 */
public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);


    @Test
    public void  getUserById(){
        //获取
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(5);
        System.out.println(userById);

        //关闭
        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info: 进入了testLog4j");
        logger.debug("debug: 进入了testLog4j");
        logger.error("error: 进入了testLog4j");
    }

    @Test
    public void getUsersbylimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("start",0);
        map.put("end",3);

        List<User> usersByLimit = mapper.getUsersbylimit(map);
        for (User user : usersByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}