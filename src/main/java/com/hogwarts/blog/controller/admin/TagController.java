package com.hogwarts.blog.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hogwarts.blog.pojo.Tag;
import com.hogwarts.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;


    //分页查询分类列表
    @GetMapping("/tags")
    public String list(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //按照排序字段 倒序 排序
        String orderBy = "id desc";
        PageHelper.startPage(pageNum,5,orderBy);
        List<Tag> list = tagService.listTag();
        PageInfo<Tag> pageInfo = new PageInfo<Tag>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/tags";
    }


    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }

    @PostMapping("/tags")
    public String post( Tag tag, BindingResult result, RedirectAttributes attributes){
        //标签已存在校验
        Tag t = tagService.getTagByName(tag.getName());
        if(t!=null){
            //手动往result中加一些错误
            result.rejectValue("name","nameError","标签已经存在，不能重复添加");
        }
        //错误校验
        if(result.hasErrors()){
            return "admin/tags-input";
        }
        Tag t1 = tagService.saveTag(tag);
        if(t1!=null){
            attributes.addFlashAttribute("message","添加成功");
        }else {
            attributes.addFlashAttribute("message","添加失败");
        }

        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/input")
    public String edit(@PathVariable(name = "id") Long id,Model model){
        model.addAttribute("tag",tagService.getTag(id));
        return "admin/tags-input";
    }

    @PostMapping("/tags/{id}")
    public String editPost(Tag tag,BindingResult result,@PathVariable Long id,RedirectAttributes attributes){
        //标签已经存在校验
        Tag t = tagService.getTagByName(tag.getName());
        if(t!=null){
            result.rejectValue("name","nameError","标签已经存在，不能重复添加");
        }
        if(result.hasErrors()){
            return "admin/tags-input";
        }
        Tag t1 = tagService.updateTag(id, tag);
        if(t1==null){
            attributes.addFlashAttribute("message","更新失败");
        }else {
            attributes.addFlashAttribute("message","更新成功");
            System.out.println(t1);
        }
        return "redirect:/admin/tags";
    }
    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/tags";
    }
}
