package com.kaishengit.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;
import com.kaishengit.entity.MovieExample;
import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MovieExampleTestCase {

    private SqlSession sqlSession;
    private MovieMapper movieMapper;

    @Before
    public void init(){
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        movieMapper = sqlSession.getMapper(MovieMapper.class);
    }

    @After
    public void destroy() {
        sqlSession.close();
    }

    @Test
    public void insert() {
        Movie movie = new Movie();
        movie.setTitle("怦然心动2");
        movie.setDirector("james");
        movie.setRate(9.0F);

//        int num = movieMapper.insert(movie);
        int num = movieMapper.insertSelective(movie);
        System.out.println("受影响行数：" + num);
    }

    @Test
    public void findById() {
        Movie movie = movieMapper.selectByPrimaryKey(101);
        System.out.println(movie);
    }

    @Test
    public void findListOr() {
        MovieExample example = new MovieExample();
        example.or().andRateGreaterThanOrEqualTo(9.0F);
        example.or().andReleaseYearEqualTo("2018");
        example.setDistinct(true);
        example.setOrderByClause("release_year desc");
        List<Movie> movieList = movieMapper.selectByExample(example);
        for(Movie movie : movieList) {
            System.out.println(movie);
        }
    }

    @Test
    public void findListByDirector() {
        MovieExample example = new MovieExample();
        example.createCriteria().andDirectorLike("%詹姆斯·卡梅隆%")
                .andRateGreaterThanOrEqualTo(9.0F);

        List<Movie> movieList = movieMapper.selectByExample(example);
        for(Movie movie : movieList) {
            System.out.println(movie);
        }
    }
    @Test
    public void testfindAll() {
        MovieExample example = new MovieExample();

        List<Movie> movieList = movieMapper.selectByExample(example);
        for(Movie movie : movieList) {
            System.out.println(movie);
        }
    }

    @Test
    public void testCount() {
        int count = movieMapper.count();
        System.out.println(count);
    }

    @Test
    public void page() {
//        PageHelper.startPage(1,10);
        PageHelper.offsetPage(0,10);
        MovieExample example = new MovieExample();

        List<Movie> movieList = movieMapper.selectByExample(example);
        for(Movie movie : movieList) {
            System.out.println(movie);
        }

        PageInfo<Movie> page = new PageInfo<>(movieList);
        System.out.println(page.getPageSize());
        System.out.println(page.getPages());
    }

    @Test
    public void updateById() {
        Movie movie = movieMapper.selectByPrimaryKey(776);
        movie.setRate(9.1F);

//        MovieExample example = new MovieExample();
        movieMapper.updateByPrimaryKey(movie);

    }


    @Test
    public void UpdateByDirector() {
        MovieExample example = new MovieExample();
        example.createCriteria().andDirectorLike("%james%");

        Movie movie = new Movie();
        movie.setReleaseYear("2018");

        movieMapper.updateByExampleSelective(movie, example);


    }

}
