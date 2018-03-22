import com.kaishengit.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.io.Reader;

public class UserMapperTestCase {

    @Test
    public void testFindById()throws Exception{
        // 1.加载配置文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//        InputStream inputStream = Resources.getResourceAsStream("xxx");
        // 2.创建SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);

        // 3.创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.操作数据库
        // UserMapper.xml 的namespace + id
        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",2);

        System.out.println(user);
        // 5.关闭sqlSession
        sqlSession.close();
    }

}
