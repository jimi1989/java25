package com.kaishengit.test;

import com.kaishengit.entity.Movie;
import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class MovieMapperTestCase {

    private SqlSession sqlSession;
    private MovieMapper movieMapper;
    @Before
    public void init() {
        // 自动提交事务
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        // 动态代理 动态生成
        movieMapper = sqlSession.getMapper(MovieMapper.class);
    }

    @After
    public void destroy() {
        // 5.关闭sqlSession
        sqlSession.close();
    }

       @Test
    public void testFindList() {
//        String title = "%大话西游%";
        List<Movie> movieList = movieMapper.findList(null);
        for(Movie movie : movieList) {
            System.out.println(movie);
        }
    }

    @Test
    public void testFindByParams() {
        String title = "";//"%泰坦尼克号%";
        String director = "%詹姆斯·卡梅隆%";

        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("director",director);

        List<Movie> movieList = movieMapper.findByParams(params);
        for(Movie movie : movieList) {
            System.out.println(movie);
        }
    }

    @Test
    public void testFindByIdList() {
        List<Integer> idList = Arrays.asList(101,102,103);
        List<Movie> movieList = movieMapper.findByIdList(idList);
        for(Movie movie : movieList) {
            System.out.println(movie);
        }
    }

    @Test
    public void testINsertBatch() {
        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie();
        movie.setTitle("千与千寻");
        movie.setDirector("宫崎骏");
        movie.setRate(9.1F);

        Movie movie2 = new Movie();
        movie2.setTitle("龙猫");
        movie2.setDirector("宫崎骏");
        movie2.setRate(8.9F);
        movieList.add(movie);
        movieList.add(movie2);

        movieMapper.insertBatch(movieList);

    }

}
