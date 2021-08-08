package com.hogwarts.blog.service;

import com.hogwarts.blog.pojo.Task;
import com.hogwarts.blog.vo.TaskSearch;

import java.util.List;

public interface TaskService {

    List<Task> listAllTask();

    List<Task> listTaskByVo(TaskSearch taskSearch);

    void saveTask(Task task);
}
