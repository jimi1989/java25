package com.kaishengit.mapper;

import com.kaishengit.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 *
 * UserMapper.xml映射接口
 * @author 靳江浩
 * @date 2018-3-22
 */
@CacheNamespace
public interface UserMapper {

    /**  
     * 保存user对象
     * @date 2018-3-22
     * @param user 对象
     * @return void  
     */
    @Insert("insert into t_user (user_name, address, tel) values (#{userName}, #{address}, #{tel})")
    @Options(useGeneratedKeys =  true, keyProperty = "id")
    int save(User user);

    @Select("select * from t_user where id = #{id}")
    @Options(useCache = false)
    User findById(int id);
    @Select("select * from t_user")
    List<User> findAll();
    List<User> page(Map<String, Integer> map);
    List<User> page2(int start, int size);
    List<User> page3(@Param("start") int start, @Param("size") int size);
    @Update("update t_user set user_name = #{userName} , address = #{address}, tel = #{tel}  where id = #{id}")
    int update(User user);
    @Delete("delete from t_user where id=#{id}")
    int delById(int id);


}
