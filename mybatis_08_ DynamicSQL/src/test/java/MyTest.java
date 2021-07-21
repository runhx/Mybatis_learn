import com.zhu.dao.BlogMapper;
import com.zhu.pojo.Blog;
import com.zhu.utils.IDUtils;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @author shkstart @create 2021-06-28 17:08
 */
public class MyTest {
    @Test
    //向数据库插入数据
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();

        blog.setId(IDUtils.getID());
        blog.setTitle("Mybatis 如此简单");
        blog.setAuthor("梦想飞往全世界的猪");
        blog.setCreatTime(new Date());
        blog.setViews(9999999);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("java 如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("spring 如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("微服务 如此简单");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    //动态SQL if 测试
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("author","梦想飞往全世界的猪");
//        map.put("title","java 如此简单");

        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("author","梦想飞往全世界的猪");
        map.put("title","微服务 如此简单");
        map.put("views",9999999);

        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("author","梦想飞往全世界的猪");
        map.put("title","喝水 如此简单");
        map.put("id","3cae2c610c814dd5b5a0f3a98b2cb27d");
        map.put("views",9999999);
        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
