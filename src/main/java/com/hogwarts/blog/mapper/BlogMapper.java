package com.hogwarts.blog.mapper;

import com.hogwarts.blog.pojo.Blog;
import com.hogwarts.blog.vo.BlogQuery;
import com.hogwarts.blog.vo.BlogSearch;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface BlogMapper {


    List<BlogQuery> findAll();


    Blog findById(Long id);



    @Delete("delete  from t_blog where id = #{id}")
    //配置文件中，要注意删除外键
    void delete(Long id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into t_blog (commentabled,create_time,first_picture,flag,published,recommend,share_statement,title,update_time,views,type_id,user_id,content,description,appreciation) " +
            "values(#{commentabled},#{createTime},#{firstPicture},#{flag},#{published},#{recommend},#{shareStatement},#{title},#{updateTime},#{views},#{type.id},#{user.id},#{content},#{description},#{appreciation})")
    void addBlog(Blog blog);

    List<BlogQuery> findBlogByVo(BlogSearch blogSearch);

    @Update("update t_blog set " +
            "flag=#{flag},title=#{title},content=#{content},first_picture=#{firstPicture},description=#{description},recommend=#{recommend},share_statement=#{shareStatement},appreciation=#{appreciation},commentabled=#{commentabled} " +
            "where id = #{id}")
    void updateBlog(Blog blog);


    List<BlogQuery> listRecommendBlogTop(Integer i);


    Integer count();

    List<String> findGroupYear();

    List<Blog> findByYear(String year);

    List<Blog> findBlogByTagId(Long id);

    List<BlogQuery> findBlogByTypeId(Long id);

    List<Blog> getNewBlogs(Integer i);
}
