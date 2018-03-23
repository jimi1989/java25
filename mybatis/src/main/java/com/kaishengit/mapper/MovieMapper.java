package com.kaishengit.mapper;

import com.kaishengit.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MovieMapper {
    List<Movie> findList(@Param("title") String title);
    List<Movie> findByParams(Map<String,Object> params);
    List<Movie> findByIdList(@Param("idList") List<Integer> idList);
    void insertBatch(List<Movie> movieList);



}
