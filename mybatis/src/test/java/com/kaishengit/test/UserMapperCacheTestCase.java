package com.kaishengit.test;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperCacheTestCase {

    @Test
    public void testFindById() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findById(2);
        System.out.println(user);
        sqlSession.close();


        SqlSession sqlSession2 = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        User user2 = userMapper2.findById(2);
        System.out.println(user2);
        sqlSession.close();
    }

}
