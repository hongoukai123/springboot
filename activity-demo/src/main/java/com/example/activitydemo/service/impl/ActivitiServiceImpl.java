package com.example.activitydemo.service.impl;

import com.example.activitydemo.constant.BasisConstant;
import com.example.activitydemo.service.IActivitiService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Activiti业务实现类
 * @author hok
 * @since 2019-7-17 16:28:00
 */
@Service("activitiService")
public class ActivitiServiceImpl implements IActivitiService {

    @Autowired
    private ProcessEngine processEngine;

    @Override
    public boolean startProcesses(String bizId, String applyUser) {
        //取得任务服务
        TaskService taskService = processEngine.getTaskService();
        //创建一个任务查询对象
        TaskQuery taskQuery = taskService.createTaskQuery();
        //办理人的任务列表
        List<Task> taskList = taskQuery.taskAssignee(applyUser).list();
        //遍历任务列表
        if (taskList != null && taskList.size()>0){
            for (Task task : taskList){
                processEngine.getTaskService().complete(task.getId());
            }
        }
        return false;
    }
}
