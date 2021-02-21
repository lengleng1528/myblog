package com.hogwarts.blog.mapper;


import com.hogwarts.blog.pojo.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TypeMapper {
    @Delete("delete  from t_type where id = #{id}")
    void delete(Long id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into t_type (id , name) values(#{id},#{name})")
    void addType(Type type);
    
    @Update("update t_type set name = #{name}  where id = #{id}")
    void updateType(Type type);

    @Select("select * from t_type where id = #{id}")
    Type findById(Long id);

    @Select("select * from t_type where name = #{name}")
    Type findByName(String name);

    @Select("select * from t_type")
    List<Type> findAll();

    List<Type> findTopType(Integer size);
}
