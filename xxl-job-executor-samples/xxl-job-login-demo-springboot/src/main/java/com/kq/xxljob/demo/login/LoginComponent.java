package com.kq.xxljob.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class LoginComponent {

    @Autowired
    private RestTemplate restTemplate;

    public void login(String userName,String password) {

        String url = "http://localhost:8080/xxl-job-admin/login";

//        restTemplate.postForEntity()

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("userName",userName);
        map.add("password",password);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(url, request, String.class);


    }

}
