package com.hogwarts.blog.service.impl;

import com.hogwarts.blog.mapper.OrderMapper;
import com.hogwarts.blog.pojo.Order;
import com.hogwarts.blog.service.OrderService;
import com.hogwarts.blog.vo.OrderSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> listOrderByVo(OrderSearch orderSearch) {
        return orderMapper.findOrderByVo(orderSearch);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderMapper.listAll();
    }

}
