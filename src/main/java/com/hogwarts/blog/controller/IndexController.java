package com.hogwarts.blog.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hogwarts.blog.pojo.Blog;
import com.hogwarts.blog.service.BlogService;
import com.hogwarts.blog.service.TagService;
import com.hogwarts.blog.service.TypeService;
import com.hogwarts.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model) {
        //按照排序字段 倒序 排序
        String orderBy = "id desc";
        PageHelper.startPage(pageNum,5,orderBy);
        List<BlogQuery> list = blogService.getAllBlogs();
        PageInfo<BlogQuery> pageInfo = new PageInfo<BlogQuery>(list);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("types",typeService.listTypeTop(3));
        model.addAttribute("tags", tagService.listTagTop(3));
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(5));
        return "index";
    }


    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        Blog blog = blogService.getAndConvert(id);
        model.addAttribute("blog",blog);
        return "blog";
    }

}
