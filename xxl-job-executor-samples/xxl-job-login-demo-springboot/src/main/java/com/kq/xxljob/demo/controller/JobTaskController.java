package com.kq.xxljob.demo.controller;

import com.kq.xxljob.demo.dto.XxlJobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/task")
public class JobTaskController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/add")
    public String index() {



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

        jobInfo.setScheduleConf(cron);
        jobInfo.setExecutorHandler(executorHandler);  // 重要
        jobInfo.setGlueType("BEAN");  // 这个好像只有新增有

        jobInfo.setExecutorRouteStrategy("FIRST");
        jobInfo.setMisfireStrategy("DO_NOTHING");
        jobInfo.setExecutorBlockStrategy("SERIAL_EXECUTION");

        return jobInfo;


    }


}
