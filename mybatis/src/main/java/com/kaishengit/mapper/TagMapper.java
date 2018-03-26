package com.kaishengit.mapper;

import com.kaishengit.entity.Tag;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagMapper {

    @Select("SELECT " +
            "tag.id, " +
            "tag.tag_name " +
            "FROM " +
            "t_student stu " +
            "INNER JOIN t_stu_tag st ON stu.id = st.sid " +
            "INNER JOIN t_tag tag ON tag.id = st.tid " +
            "WHERE " +
            "stu.id = #{id} ")
    List<Tag> findByStuId(int id);

}
