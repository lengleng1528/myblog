package com.hogwarts.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hogwarts.blog.pojo.Task;
import com.hogwarts.blog.service.TaskService;
import com.hogwarts.blog.vo.TaskSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    //展示所有的任务
    @GetMapping("/task")
    public String list(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, Model model) {
        //按照排序字段 倒序 排序
        //String orderBy = "update_time desc";
        PageHelper.startPage(pageNum, 5);
        List<Task> list = taskService.listAllTask();
        PageInfo<Task> pageInfo = new PageInfo<Task>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tasks";
    }


    //任务条件查询
    @PostMapping("/task/search")
    public String search(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, TaskSearch taskSearch, Model model){
        //按照排序字段 倒序 排序
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,5,orderBy);
        List<Task> list = taskService.listTaskByVo(taskSearch);
        PageInfo<Task> pageInfo = new PageInfo<Task>(list);
        model.addAttribute("pageInfo",pageInfo);
        //只更新表格中的数据
        return "admin/tasks::orderlist";
    }

    //下载接口
}