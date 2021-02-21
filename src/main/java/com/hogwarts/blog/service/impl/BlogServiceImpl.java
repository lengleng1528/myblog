package com.hogwarts.blog.service.impl;


import com.hogwarts.blog.NotFoundException;
import com.hogwarts.blog.mapper.BlogMapper;
import com.hogwarts.blog.mapper.BlogTagMapper;
import com.hogwarts.blog.pojo.Blog;
import com.hogwarts.blog.pojo.Tag;
import com.hogwarts.blog.service.BlogService;
import com.hogwarts.blog.utils.MarkdownUtils;
import com.hogwarts.blog.vo.BlogQuery;
import com.hogwarts.blog.vo.BlogSearch;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private BlogTagMapper blogTagMapper;

    @Override
    public List<BlogQuery> listBlogByVo(BlogSearch blogSearch) {
        return blogMapper.findBlogByVo(blogSearch);
    }

    @Override
    public List<BlogQuery> getAllBlogs() {
        return blogMapper.findAll();
    }

    @Override
    public Blog getBlog(Long id) {
        return blogMapper.findById(id);
    }


    @Override
    public Blog saveBlog(Blog blog) {
        blog.setViews(0);
        blogMapper.addBlog(blog);
        //blog和tag之间的多对多操作
        for(Tag tag:blog.getTags()){
            blogTagMapper.saveBlogTags(blog,tag);
        }
        return blogMapper.findById(blog.getId());
    }

    @Override
    public Blog updateBlog(Blog blog) {
        Blog b = blogMapper.findById(blog.getId());
        if(b==null){
            throw new NotFoundException("该博客不存在");
        }
        blogMapper.updateBlog(blog);
        return blogMapper.findById(blog.getId());
    }

    @Override
    public void deleteBlog(Long id) {
        blogMapper.delete(id);
    }

    @Override
    public List<BlogQuery> listRecommendBlogTop(Integer i) {
        return blogMapper.listRecommendBlogTop(i);
    }

    @Override
    public List<Blog> listBlogByTagId(Long id) {
        return blogMapper.findBlogByTagId(id);
    }

    @Override
    public List<BlogQuery> listBlogByTypeId(Long id) {
        return blogMapper.findBlogByTypeId(id);
    }

    @Override
    public Map<String, List<Blog>> archiveBlog() {
        List<String> years = blogMapper.findGroupYear();
        Map<String, List<Blog>> map = new HashMap<>();
        for (String year : years) {
            map.put(year, blogMapper.findByYear(year));
        }
        return map;
    }

    @Override
    public Integer countBlog() {
        return blogMapper.count();
    }

    @Override
    public Blog getAndConvert(Long id) {
        Blog blog = blogMapper.findById(id);
        if(blog==null){
            throw new NotFoundException("该博客不存在");
        }
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(blog.getContent()));
        return blog;
    }

    @Override
    public List<Blog> listNewBlog(Integer i) {
        List<Blog> blogs = blogMapper.getNewBlogs(i);
        return blogs;
    }
}
