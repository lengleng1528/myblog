package com.hogwarts.blog.service;

import com.hogwarts.blog.pojo.Order;
import com.hogwarts.blog.vo.OrderSearch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    //订单条件查询
    List<Order> listOrderByVo(OrderSearch orderSearch);


    List<Order> getAllOrders();
}
