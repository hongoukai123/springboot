package com.example.flowabledemo.handler;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/**
 * 集团审核员
 * @author hok
 * @since 2019-7-22 16:35:52
 */
public class GroupTaskHandler implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("7");
    }
	
}
