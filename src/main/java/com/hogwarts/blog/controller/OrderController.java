package com.hogwarts.blog.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hogwarts.blog.pojo.Order;
import com.hogwarts.blog.pojo.Task;
import com.hogwarts.blog.service.OrderService;
import com.hogwarts.blog.service.TaskService;
import com.hogwarts.blog.vo.OrderSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private TaskService taskService;

    //分页查询全部订单
    @GetMapping("/")
    public String list(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,Model model){
        //按照排序字段 倒序 排序
        //String orderBy = "update_time  desc";
        PageHelper.startPage(pageNum,5);
        List<Order> list = orderService.getAllOrders();
        PageInfo<Order> pageInfo = new PageInfo<Order>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/orders";
    }


    //订单条件查询
    @PostMapping("/order/search")
    public String search(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, OrderSearch orderSearch, Model model){
        //按照排序字段 倒序 排序
        //String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,5);
        List<Order> list = orderService.listOrderByVo(orderSearch);
        PageInfo<Order> pageInfo = new PageInfo<Order>(list);
        model.addAttribute("pageInfo",pageInfo);
        //只更新表格中的数据
        return "admin/orders::orderlist";
    }

    //点击导出订单给提示，插入任务表并跳转
    @PostMapping("/order/output")
    public String output(OrderSearch orderSearch){
        Task task = new Task();
        String condition = JSON.toJSONString(orderSearch);
        //task.setUser();
        task.setCondition(condition);
        task.setCreatedAt(new Date());
        task.setUpdatedAt(new Date());
        taskService.saveTask(task);
        return "redirect:/task";
    }
}
