package com.lhao.bookdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description :
 * @Author 小豪
 * @Date 2022/9/10 22:32
 * @Version 1.0
 **/
@Controller
public class IndexController {

    /**
     * @return
     * @Description:To:登录页面
     */
    @RequestMapping(value = {"/", "/login.html"})
    public String login() {
        return "login";
    }

    /**
     * @return
     * @Description:To:主页面
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * @return
     * @Description:主页顶部
     */
    @GetMapping("/main/top.html")
    public String top() {
        return "main/top";
    }

    /**
     * @return
     * @Description:主页主体
     */
    @GetMapping("/main/main.html")
    public String main() {
        return "main/main";
    }

    /**
     * @return
     * @Description:主页左端
     */
    @GetMapping("/main/left.html")
    public String left() {
        return "main/left";
    }
}
