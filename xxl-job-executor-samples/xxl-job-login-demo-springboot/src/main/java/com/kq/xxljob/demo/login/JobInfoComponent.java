package com.kq.xxljob.demo.login;


import com.kq.xxljob.demo.dto.XxlJobInfo;
import com.kq.xxljob.demo.util.GsonUtil;
import com.kq.xxljob.demo.util.JacksonUtil;
import com.kq.xxljob.demo.util.MapUtil;
import com.kq.xxljob.demo.util.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class JobInfoComponent {

    private Logger logger = LoggerFactory.getLogger(LoginComponent.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoginComponent loginComponent;


    public Long add(XxlJobInfo jobInfo) throws Exception{

        String url = "http://localhost:8080/xxl-job-admin/jobinfo/add";

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(MapUtil.mapToMultiValueMap(JacksonUtil.object2Map(jobInfo)), headers);
//        HttpEntity<XxlJobInfo> request = new HttpEntity<>(null, headers);
//      uriVariables 接收是@PathVariable

//
        ResponseEntity<String> result = restTemplate.postForEntity(url, request, String.class);
        logger.info("first login result = {} ",result);

        boolean needRetry = loginComponent.checkNeedLogin(restTemplate,result);

        if(needRetry){
            result = restTemplate.postForEntity(url, request, String.class);
            logger.info("second login result = {} ",result);
        }

        Map<String, String> resultMap = GsonUtil.stringToMap(result.getBody());

        logger.info("job add resultMap = {} ",resultMap);


        return NumberUtil.toLong(resultMap.get("content"));

    }

}
