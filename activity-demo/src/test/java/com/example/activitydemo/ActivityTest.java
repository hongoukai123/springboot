package com.example.activitydemo;

import com.example.activitydemo.activiti.ActivitiConfig;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * 测试工作流
 * @author hok
 * @since 2019-7-17 16:24:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ActivitiConfig.class)
@WebAppConfiguration
public class ActivityTest {

    @Autowired
    private ProcessEngine processEngine;

    /**
     * 部署工作流引擎
     */
    @Test
    public void deploy(){
        //获取仓库服务 ：管理流程定义
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()//创建一个部署的构建器
                .addClasspathResource("processes/ResourceAudit.xml")//从类路径中添加资源,一次只能添加一个资源
                .name("请求单流程")//设置部署的名称
                .category("办公类别")//设置部署的类别
                .deploy();
        System.out.println("部署的id:"+deploy.getId());
        System.out.println("部署的名称:"+deploy.getName());
    }

    /**
     * 执行工作流程
     */
    @Test
    public void startProcess(){
        //指定执行我们刚才部署的工作流程
        String processDefiKey = "resourceBill";
        //取运行时的服务
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //取得流程实例,通过流程定义的key来执行流程
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(processDefiKey);
        System.out.println("流程ID：" + pi.getId());
        System.out.println("流程定义ID：" + pi.getProcessDefinitionId());
    }

    /**
     * 根据代理人查询当前任务
     */
    @Test
    public void queryTask(){
        //任务办理人
        String assignee = "王麻子";
        //取得任务服务
        TaskService taskService = processEngine.getTaskService();
        //创建一个任务查询对象
        TaskQuery taskQuery = taskService.createTaskQuery();
        //办理人的任务列表
        List<Task> taskList = taskQuery.taskAssignee(assignee).list();
        //遍历任务列表
        if (taskList != null && taskList.size()>0){
            for (Task task : taskList){
                System.out.println("任务办理人：" + task.getAssignee());
                System.out.println("任务ID：" + task.getId());
                System.out.println("任务的名称：" + task.getName());
            }
        }
    }

    /**
     * 处理任务
     */
    @Test
    public void compileTask(){
        //任务ID
        String taskId = "40005";
        //处理任务
        processEngine.getTaskService().complete(taskId);
        System.out.println("当前任务执行完毕");
    }

    /**
     * 查看bpmn资源图片
     */
    @Test
    public void viewImage() throws IOException {
        String deploymentId="37501";
        String imageName=null;
        //取得某个部署的资源的名称，deploymentId
        List<String> resourceNames = processEngine.getRepositoryService().getDeploymentResourceNames(deploymentId);
        if (resourceNames != null && resourceNames.size()>0){
            for (String temp : resourceNames){
                if (temp.indexOf(".png")>0){
                    imageName = temp;
                }
            }
        }
        //读取资源
        InputStream resourceAsStream = processEngine.getRepositoryService().getResourceAsStream(deploymentId, imageName);
        //把文件输入流写入到文件中
        File file = new File("F:\\image\\" + imageName);
        FileUtils.copyInputStreamToFile(resourceAsStream, file);
    }

    /**
     * 查看流程定义
     */
    @Test
    public void queryProcessDefination(){
        String processDefiKey = "resourceBill";
        //获取流程定义列表
        List<ProcessDefinition> list = processEngine.getRepositoryService().createProcessDefinitionQuery()
                .processDefinitionKey(processDefiKey)
                .latestVersion()    //最新版本
                .orderByProcessDefinitionVersion().desc()   //按照版本降序排序
                .list();
        //遍历结果
        if (list != null && list.size()>0){
            for (ProcessDefinition temp : list){
                System.out.println("流程定义的ID：" + temp.getId());
                System.out.println("流程定义的KEY：" + temp.getKey());
                System.out.println("流程定义的版本：" + temp.getVersion());
                System.out.println("流程定义部署的ID：" + temp.getDeploymentId());
                System.out.println("流程定义的名称：" + temp.getName());
            }
        }
    }

    /**
     * 部署流程定义，资源来自zip格式
     */
    @Test
    public void deployProcessDefiByZip(){
        InputStream in=getClass().getClassLoader().getResourceAsStream("zip/BuyBill.zip");
        Deployment deploy = processEngine.getRepositoryService()
                .createDeployment()
                .name("采购流程")
                .addZipInputStream(new ZipInputStream(in))
                .deploy();
        System.out.println("部署名称:"+deploy.getName());
        System.out.println("部署id:"+deploy.getId());
    }

    /**
     * 删除流程定义
     */
    @Test
    public void deleteProcessDefi(){
        //通过部署id来删除流程定义
        String deploymentId="37501";
        processEngine.getRepositoryService().deleteDeployment(deploymentId);
    }

}
