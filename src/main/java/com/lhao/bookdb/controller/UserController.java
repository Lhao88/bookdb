package com.lhao.bookdb.controller;

import com.lhao.bookdb.bean.User;
import com.lhao.bookdb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @ClassName UserController
 * @Description :
 * @Author 小豪
 * @Date 2022/9/10 22:39
 * @Version 1.0
 **/
@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userServiceImpl;

    /**
     * @return
     * @Description:用户登录
     */
    @PostMapping("/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("pwd") String pwd,
                        @RequestParam("valcode") String valcode,
                        HttpSession session) {
        String code = (String) session.getAttribute("KAPTCHA_SESSION_KEY");//获取session中的验证码
        String valCode = valcode.toUpperCase();
        String Code = code.toUpperCase();
        if (valCode.equals(Code)) { //判断验证码是否正确
            User loginUser = userServiceImpl.check(name, pwd);
            if (loginUser != null) { //判断该用户是否存在
                session.setAttribute("user", loginUser);
                return "redirect:/index"; //存在则登陆主页面
            } else {
                session.setAttribute("error", "找不到该用户");
                return "forward:/login.html"; //不存在返回登陆页面，并返回错误信息
            }

        }
        session.setAttribute("error", "验证码错误");
        return "forward:/login.html";  //返回登陆页面，并返回错误信息
    }


    /**
     * @return
     * @Description:修改密码
     */
    @RequestMapping("/update_pwd")
    public String setPwd(@RequestParam("pwd") String oldPwd,
                         @RequestParam("newpwd") String newPwd,
                         @RequestParam("renewpwd") String renewPwd,
                         HttpSession session) {
        session.invalidate();
        User user = (User) session.getAttribute("user");
        if (user.getPwd().equals(oldPwd)) { //输入密码正确

            if (newPwd.equals(renewPwd)) {//两次密码输入一致
                //修改密码
                user.setPwd(newPwd);
                userServiceImpl.updatePwdById(user);
                session.setAttribute("succ", "密码修改成功");
            } else {
                session.setAttribute("err", "两次密码不相同");
            }
        } else {
            session.setAttribute("err", "与原密码不匹配");
        }

        return "forward:/set_pwd.html";
    }
}
