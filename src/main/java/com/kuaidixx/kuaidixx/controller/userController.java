package com.kuaidixx.kuaidixx.controller;


import com.kuaidixx.kuaidixx.pojo.user;
import com.kuaidixx.kuaidixx.service.IUserService;
import com.kuaidixx.kuaidixx.utils.serverResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.kuaidixx.kuaidixx.common.Const.CURRENT_USER;

@RestController
@RequestMapping(value="/portal/")
public class userController {
//    @Value("${jdbc.url}")
//    private String jdbcurl;
//
//    @RequestMapping("/test")
//    public String test(){
//        return jdbcurl;
//    }
//    1.接收用户名密码
//    2.判断用户名是否存在
//    3.根据用户名密码查询
//    4.返回登录结果
//      注册
//    1.参数非空校验
//    2.用户名是否存在，手机号是否存在
//    3.注册
//    4.返回注册结果

    @Autowired
    IUserService userService;
    @RequestMapping(value="user/login.do")
    public serverResponse login(String username, String password, HttpSession session){
        serverResponse serverResponse=userService.loginLogic(username,password);
        //将登录成功的用户信息放入session，其他模块访问的时候就能判断
        if(serverResponse.isSuccess()){
            session.setAttribute(CURRENT_USER,serverResponse.getData());
        }
        return serverResponse;
    }
    @RequestMapping(value="user/register.do")
    public  serverResponse register(user user){
        return userService.registerLogic(user);
    }

}
