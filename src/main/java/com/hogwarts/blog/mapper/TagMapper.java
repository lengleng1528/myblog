package com.hogwarts.blog.mapper;


import com.hogwarts.blog.pojo.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TagMapper {

    @Select("select * from t_tag where id = #{id}")
    Tag findById(Long id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into t_tag (name) values(#{name})")
    void addTag(Tag tag);

    @Select("select * from t_tag where name = #{name}")
    Tag findByName(String name);

    @Update("update t_tag set name = #{name}  where id = #{id}")
    void updateTag(Tag t);

    @Delete("delete  from t_tag where id = #{id}")
    void delete(Long id);

    @Select("select * from t_tag")
    List<Tag> findAll();

    //sql在配置文件中
    List<Tag> findByList(@Param("ids") List<Long> idList);


    List<Tag> findTopTag(Integer size);


}
