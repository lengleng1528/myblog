package com.hogwarts.blog.mapper;

import com.hogwarts.blog.pojo.Order;
import com.hogwarts.blog.vo.OrderSearch;

import java.util.List;

public interface OrderMapper {

    List<Order> findOrderByVo(OrderSearch orderSearch);

    List<Order> listAll();
}
