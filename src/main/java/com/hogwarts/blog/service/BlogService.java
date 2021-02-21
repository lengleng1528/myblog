package com.hogwarts.blog.service;


import com.hogwarts.blog.pojo.Blog;
import com.hogwarts.blog.vo.BlogQuery;
import com.hogwarts.blog.vo.BlogSearch;

import java.util.List;
import java.util.Map;

public interface BlogService {

    Blog getBlog(Long id);

    List<BlogQuery> getAllBlogs();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Blog blog);

    void deleteBlog(Long id);
    
    List<BlogQuery> listBlogByVo(BlogSearch blogSearch);

    List<BlogQuery> listRecommendBlogTop(Integer i);

    Map<String, List<Blog>> archiveBlog();

    Integer countBlog();

    List<Blog> listBlogByTagId(Long id);

    List<BlogQuery> listBlogByTypeId(Long id);

    Blog getAndConvert(Long id);


    List<Blog> listNewBlog(Integer i);
}
