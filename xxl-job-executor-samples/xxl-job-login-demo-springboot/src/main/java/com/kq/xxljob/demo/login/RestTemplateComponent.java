package com.kq.xxljob.demo.login;

import com.kq.xxljob.demo.dto.XxlJobInfo;
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

@Component
public class RestTemplateComponent {

    private Logger logger = LoggerFactory.getLogger(LoginComponent.class);

    @Autowired
    private RestTemplate restTemplate;

    public void sendPost(XxlJobInfo jobInfo) {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//
//        ResponseEntity<String> result = restTemplate.postForEntity(url, request, String.class);
//        logger.info("login result = {} ",result);

    }

}
