package com.kq.xxljob.demo.controller;

import com.kq.xxljob.demo.dto.XxlJobInfo;
import com.kq.xxljob.demo.login.JobInfoComponent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/task")
public class JobTaskController {

    private Logger logger = LoggerFactory.getLogger(JobTaskController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JobInfoComponent jobInfoComponent;


    // http://localhost:8083/task/add
    @GetMapping("/add")
    public String index() throws Exception{

        Long id = jobInfoComponent.add(this.getXxlJobInfo());
        logger.info("id={}",id);

        return "ok";
    }

    private XxlJobInfo getXxlJobInfo(){

        String executorHandler = "demoJobHandler";
        String cron = "0 30 10 * * ?";
        String jobDesc = "myExample2";
        int jobGroup = 7;


        XxlJobInfo jobInfo = new XxlJobInfo();
        jobInfo.setJobGroup(jobGroup); // jobGroupId
        jobInfo.setJobDesc(jobDesc);
        jobInfo.setAuthor("admin");
        jobInfo.setScheduleType("CRON");
        jobInfo.setTriggerStatus(0);  // 调度状态：0-停止，1-运行

//        jobInfo.setAddTime(new Date()); // 界面上好像没有？？？

        jobInfo.setScheduleConf(cron);
        jobInfo.setExecutorHandler(executorHandler);  // 重要
        jobInfo.setGlueType("BEAN");  // 这个好像只有新增有
        jobInfo.setGlueRemark("GLUE代码初始化");

        jobInfo.setExecutorRouteStrategy("FIRST");
        jobInfo.setMisfireStrategy("DO_NOTHING");
        jobInfo.setExecutorBlockStrategy("SERIAL_EXECUTION");

        return jobInfo;


    }


}
