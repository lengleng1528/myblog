package com.hogwarts.blog.service.impl;


import com.hogwarts.blog.NotFoundException;
import com.hogwarts.blog.mapper.TypeMapper;
import com.hogwarts.blog.pojo.Type;
import com.hogwarts.blog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Transactional
    @Override
    public Type saveType(Type type) {
        typeMapper.addType(type);
        //返回自增的id
        return typeMapper.findById(type.getId());
    }


    @Override
    public Type getType(Long id) {
        return typeMapper.findById(id);
    }


    @Override
    public Type getTypeByName(String name) {
        return typeMapper.findByName(name);
    }


    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeMapper.findById(id);
        if(t==null){
            throw  new NotFoundException("不存在该类型");
        }
        //BeanUtils.copyProperties(type,t);
        typeMapper.updateType(type);
        return typeMapper.findById(id);

    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeMapper.delete(id);
    }

    @Override
    public List<Type> listType() {
        return typeMapper.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        return typeMapper.findTopType(size);
    }
}
