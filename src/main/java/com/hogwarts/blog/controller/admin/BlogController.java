package com.hogwarts.blog.controller.admin;


import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class BlogController {

    //private BlogService blogService;


//    //分页查询分类列表
//    @GetMapping("/blogs")
//    public String list(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,Model model){
//        //按照排序字段 倒序 排序
//        String orderBy = "update_time  desc";
//        PageHelper.startPage(pageNum,5,orderBy);
//        return "orders";
//    }


//    @PostMapping("/blogs/search")
//    public String search(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, BlogSearch blogSearch, Model model){
//        //按照排序字段 倒序 排序
//        String orderBy = "update_time desc";
//        PageHelper.startPage(pageNum,5,orderBy);
//        //只更新表格中的数据
//        return "admin/orders::orderlist";
//    }

//    @GetMapping("/blogs/input")
//    public String input(Model model){
//        //为了方便修改的时候在页面中拿到一些初始化的值
//        model.addAttribute("blog",new Blog());
//        //进入到新增页面时初始化标签和分类的下拉页面
//        model.addAttribute("types",typeService.listType());
//
//        return "downloadCenter";
//    }

//    @GetMapping("/blogs/{id}/input")
//    public String editInput(Model model,@PathVariable Long id){
//        //为了方便修改的时候在页面中拿到一些初始化的值
//        Blog blog = blogService.getBlog(id);
//        //把tagIds初始化成字符串
//        blog.init();
//        model.addAttribute("blog",blog);
//        //进入到新增页面时初始化标签和分类的下拉页面
//        model.addAttribute("types",typeService.listType());
//        model.addAttribute("tags",tagService.listTag());
//
//        return "admin/blogs-input";
//    }

//    @PostMapping("/blogs")
//    //新增和修改共用一个页面
//    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
//
//        blog.setUser((User) session.getAttribute("user"));
//
//        blog.setType(typeService.getType(blog.getType().getId()));
//        System.out.println(blog.getTagIds());
//        System.out.println(tagService.listTag(blog.getTagIds()));
//        blog.setTags(tagService.listTag(blog.getTagIds()));
//        Blog b;
//        if(blog.getId()==null){
//            blog.setCreateTime(new Date());
//            blog.setUpdateTime(new Date());
//            b = blogService.saveBlog(blog);
//        }else {
//            blog.setUpdateTime(new Date());
//            b = blogService.updateBlog(blog);
//        }
//        if (b==null){
//            attributes.addFlashAttribute("message","操作失败");
//        }else {
//            attributes.addFlashAttribute("message","操作成功");
//        }
//
//        return "redirect:/admin/blogs";
//    }


//    @GetMapping("/blogs/{id}/delete")
//    public String delete(@PathVariable Long id,RedirectAttributes attributes){
//        blogService.deleteBlog(id);
//        attributes.addFlashAttribute("message","删除成功");
//        return "redirect:/admin/blogs";
//    }

}
