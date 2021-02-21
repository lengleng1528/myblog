package com.hogwarts.blog.service.impl;


import com.hogwarts.blog.NotFoundException;
import com.hogwarts.blog.mapper.TagMapper;
import com.hogwarts.blog.pojo.Tag;
import com.hogwarts.blog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {


    @Autowired
    private TagMapper tagMapper;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        tagMapper.addTag(tag);
        return tagMapper.findById(tag.getId());
    }


    @Override
    public Tag getTag(Long id) {
        return tagMapper.findById(id);
    }


    @Override
    public Tag getTagByName(String name) {
        return tagMapper.findByName(name);
    }


    @Transactional
    @Override
    public Tag updateTag(Long id,Tag tag) {
        Tag t = tagMapper.findById(id);
        if(t==null){
            throw new NotFoundException("不存在该类型");
        }
        tagMapper.updateTag(tag);
        return tagMapper.findById(id);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagMapper.delete(id);
    }


    @Override
    public List<Tag> listTag() {
        return tagMapper.findAll();
    }


    @Override
    public List<Tag> listTag(String ids) {//1,2,3
        List<Long> idList = convertToList(ids);
        return tagMapper.findByList(idList);


    }

    //把字符串转化为列表
    private  List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if(!"".equals(ids)&&ids!=null){
            String[] idarray = ids.split(",");
            for(int i = 0;i<idarray.length;i++){
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        return tagMapper.findTopTag(size);
    }
}
