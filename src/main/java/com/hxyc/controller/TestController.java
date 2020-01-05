package com.hxyc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @ClassName TestController
 * @Description TODO 测试
 * @Author admin
 * @Date 2020/1/4 16:42
 **/
@Controller
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("hello");
        return "test is ok";
    }

    @RequestMapping("/add")
    public String add(){

        return "/user/add";
    }

    @RequestMapping("/update")
    public String update(){

        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){

        return "/login";
    }


    @RequestMapping("/unAuth")
    public String unAuth(){

        return "/unAuth";
    }

    /**
     * 登录逻辑处理
     * @return
     */
    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        /**
         * 使用shiro编写认证操作
         */
        //1、获取subject
        Subject subject = SecurityUtils.getSubject();

        //2、封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        //3、执行登录操作
        try{
            subject.login(token);

            //登录成功
            //跳转到test.html
            return "redirect:/testThymeleaf";
        }catch (UnknownAccountException e){
           // e.printStackTrace();
            // 登录失败 :用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            // e.printStackTrace();
            // 登录失败 :密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }
    /**
     * 测试thymeleaf页面是否可用
     * @return
     */
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model){
        //把数据存入model
        model.addAttribute("name","华西集采");
        //返回test.html
        return "test";
    }
}
