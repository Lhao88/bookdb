package com.lhao.bookdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName BookController
 * @Description :
 * @Author 小豪
 * @Date 2022/9/15 21:44
 * @Version 1.0
 **/
@Controller
public class BookController {

    /*
页面跳转
 */

    /**
     * @return
     * @Description:To:添加列表
     */
    @GetMapping("/book_add.html")
    public String book_add() {
        return "book/book_add";
    }

    /**
     * @return
     * @Description:To:图书列表
     */
    @GetMapping("/book_list.html")
    public String book_list() {
        return "book/book_list";
    }


}
