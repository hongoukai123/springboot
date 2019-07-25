package com.example.flowabledemo.handler;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/**
 * 市级审核员
 * @author hok
 * @since 2019-7-22 16:36:35
 */
public class CityTaskHandler implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("9");
    }
	
}
