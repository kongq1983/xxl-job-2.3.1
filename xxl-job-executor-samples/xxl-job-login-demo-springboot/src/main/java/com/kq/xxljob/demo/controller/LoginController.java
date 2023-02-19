package com.kq.xxljob.demo.controller;


import com.kq.xxljob.demo.login.LoginComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginComponent loginComponent;


    @RequestMapping
    public String index() {

        loginComponent.login("admin","123456");

        return "ok";
    }



}
