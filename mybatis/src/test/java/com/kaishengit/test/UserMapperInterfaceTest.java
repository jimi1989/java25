package com.kaishengit.test;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperInterfaceTest {

    private SqlSession sqlSession;
    private UserMapper userMapper;
    @Before
    public void init() {
        // 自动提交事务
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        // 动态代理 动态生成
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("赵小蓝1");
        user.setAddress("北京");
        user.setTel("010777");

        int num = userMapper.save(user);
        System.out.println("受影响的行数：" + num);
        int id = user.getId();
        System.out.println("自动生成的id：" + id);
    }

    @Test
    public void testFindById() {
        User user = userMapper.findById(2);
        System.out.println(user);
    }

    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindPage() {
        Map map = new HashMap<String, Integer>();
        map.put("start", 0);
        map.put("size", 5);
        List<User> userList = userMapper.page(map);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindPage2() {
        List<User> userList = userMapper.page2(0,3);
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindPage3() {
        List<User> userList = userMapper.page3(0,3);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testDelete() {
        userMapper.delById(20);
    }

    @Test
    public void testUpdate() {
        User user = userMapper.findById(3);
        user.setTel("11223344");
        int num = userMapper.update(user);
        System.out.println("受影响行数：" + num);
    }


    @After
    public void destroy() {
        // 5.关闭sqlSession
        sqlSession.close();
    }
}
