package com.hogwarts.blog.mapper;

import com.hogwarts.blog.pojo.Blog;
import com.hogwarts.blog.pojo.Tag;
import org.apache.ibatis.annotations.Insert;

/**
 * @author Jiayi Leng
 * @Description
 * @date 2020/12/19
 */
public interface BlogTagMapper {

    @Insert("insert into t_blog_tags (blogs_id,tags_id) values(#{param1.id},#{param2.id})")
    void saveBlogTags(Blog blog, Tag tag);
}
