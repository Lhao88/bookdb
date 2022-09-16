package com.lhao.bookdb.controller;

import com.lhao.bookdb.bean.User;
import com.lhao.bookdb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
        String code = (String) session.getAttribute("KAPTCHA_SESSION_KEY");
//        log.info("name:{}", name);
//        log.info("pwd:{}", pwd);
//        log.info("valcode:{}", valcode);
//        log.info("code:{}", code);
        String valCode = valcode.toUpperCase();
        String Code = code.toUpperCase();
        if (valCode.equals(Code)) {
            User loginUser = userServiceImpl.check(name, pwd);
            if (loginUser != null) {
                session.setAttribute("user", loginUser);
                return "redirect:/index";
            } else {
                session.setAttribute("error", "找不到该用户");
                return "forward:/login";
            }

        }
        session.setAttribute("error", "验证码错误");
        return "forward:/login";
    }

}
