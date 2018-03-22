package com.kaishengit.test;

import com.kaishengit.entity.User;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class UserMapperTestCase {
    private SqlSession sqlSession;

    @Before
    public void init() {
        // 自动提交事务
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
    }

    @Test
    public void testFindById()throws Exception{
        // 4.操作数据库
        // UserMapper.xml 的namespace + id
        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",2);

        System.out.println(user);
    }

    @Test
    public void testFindAll()throws Exception{
        // 4.操作数据库
        // UserMapper.xml 的namespace + id
        List<User> userList = sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");

        for(User user : userList){
            System.out.println(user);
        }

    }

    @Test
    public void testSave()throws Exception{
        // 4.操作数据库
        User user = new User();
        user.setUserName("赵小红");
        user.setAddress("北京");
        user.setTel("010888");
        sqlSession.insert("com.kaishengit.mapper.UserMapper.save",user);
//        手动提交事务
//        sqlSession.commit();
//        sqlSession.rollback();  回滚
    }

    @Test
    public void testUpdate()throws Exception{
        // 4.操作数据库
        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",17);
        user.setUserName("赵丽颖");
        user.setTel("13587346547");
        sqlSession.update("com.kaishengit.mapper.UserMapper.update", user);
    }

    @Test
    public void testDelete()throws Exception{
        // 4.操作数据库
        sqlSession.delete("com.kaishengit.mapper.UserMapper.delById", 6);
    }

    @After
    public void destroy() {
        // 5.关闭sqlSession
        sqlSession.close();
    }
}
