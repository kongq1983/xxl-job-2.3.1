package com.kq.xxljob.demo.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class LoginComponent {

    private Logger logger = LoggerFactory.getLogger(LoginComponent.class);

    @Autowired
    private RestTemplate restTemplate;

    public void login(String userName,String password) {

        this.login(restTemplate,userName,password);

    }


    public void login(RestTemplate restTemplate,String userName,String password) {

        String url = "http://localhost:8080/xxl-job-admin/login";

//        restTemplate.postForEntity()

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("userName",userName);
        map.add("password",password);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(url, request, String.class);
        logger.info("login result = {} ",result);

        List<String> cookies = result.getHeaders().get("Set-Cookie");

        for(String cookie : cookies) {
            System.out.println("cookie="+cookie);
        }



    }


    /**
     * @param restTemplate
     * @param result
     * @return true:重新登录过了  false:不需要
     */
    public boolean checkNeedLogin(RestTemplate restTemplate,ResponseEntity<?> result) {

        if(result.getStatusCodeValue()==302) {
            logger.info("need login ------------------------");

            this.login(restTemplate,"admin","123456");

            return true;
        }

        return false;

    }

}
