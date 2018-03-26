package com.kaishengit.mapper;

import com.kaishengit.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@CacheNamespace
public interface StudentMapper {

    @Select("select * from t_student where id = #{id}")
    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
            @Result(column = "school_id", property = "schoolId"),
            @Result(column = "school_id", property = "school", one = @One(select="com.kaishengit.mapper.SchoolMapper.findById")),
            @Result(column = "id", property = "tagList", many = @Many(select = "com.kaishengit.mapper.TagMapper.findByStuId"))
    })
    Student findById(int id);
    List<Student> findAll();

}
