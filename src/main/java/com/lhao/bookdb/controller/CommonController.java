package com.lhao.bookdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName CommenController
 * @Description :
 * @Author 小豪
 * @Date 2022/9/15 22:20
 * @Version 1.0
 **/
@Controller
public class CommonController {

    /*
    页面跳转
     */

    @GetMapping("/book_rent.html")
    public String book_rent() {
        return "book/book_rent";
    }

    @GetMapping("/return_list.html")
    public String return_list() {
        return "common/return_list";
    }

    @GetMapping("/rent_list.html")
    public String rent_list() {
        return "common/rent_list";
    }

    @GetMapping("/set_pwd.html")
    public String set_pwd() {
        return "common/set_pwd";
    }
}
