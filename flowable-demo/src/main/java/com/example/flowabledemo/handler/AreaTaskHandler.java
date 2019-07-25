package com.example.flowabledemo.handler;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/**
 * 区县审核员
 * @author hok
 * @since 2019-7-22 16:36:15
 */
public class AreaTaskHandler implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("8");
    }
	
}
