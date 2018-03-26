package com.kaishengit.mapper;

import com.kaishengit.entity.School;
import org.apache.ibatis.annotations.Select;

public interface SchoolMapper {

    @Select("select * from t_school where id = #{id}")
    School findById(int id);

}
