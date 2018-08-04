package com.server.controller;

import javax.servlet.http.HttpServletRequest;

import com.server.model.User;
import com.server.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.gson.Gson;
import java.util.Date;

@Controller
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("test")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //response响应-解决跨域
        response.addHeader("Access-Control-Allow-Origin", "*");
        String username = request.getParameter("name");
        System.out.println("name: " + username);
        String regIp = this.userService.selectUser(username);
        System.out.println("regIp: " + regIp);
        ObjectMapper mapper = new ObjectMapper();
        if (regIp == null) {
            System.out.println("name");
            String name="name";
            //response.getWriter().write(new Date().toString());
            response.getWriter().write("111");
            //response.getWriter().write("[{'s':'s'}]");
        } else {
            //response.getWriter().write(mapper.writeValueAsString(regIp));
            response.getWriter().write(regIp);
        }
        response.getWriter().close();
    }

    @RequestMapping("getUser")
    public void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("name: " + username+":"+password);
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        this.userService.insertUser(user);
        boolean result = this.userService.insertUser(user);
        System.out.println("regIp: " + result);
        if (result == true) {
            response.getWriter().write("success");
        }  if (result == false) {
            response.getWriter().write("fail");
        }
        response.getWriter().close();
    }



}
