package com.hogwarts.blog.service.impl;

import com.hogwarts.blog.mapper.TaskMapper;
import com.hogwarts.blog.pojo.Task;
import com.hogwarts.blog.service.TaskService;
import com.hogwarts.blog.vo.TaskSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> listAllTask() {
        return taskMapper.findAll();
    }

    @Override
    public List<Task> listTaskByVo(TaskSearch taskSearch) {
        return taskMapper.findTaskByVo(taskSearch);
    }

    @Override
    public void saveTask(Task task) {
        taskMapper.addTask(task);
    }


}
