package com.lhao.bookdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName BTypeController
 * @Description :
 * @Author 小豪
 * @Date 2022/9/15 21:47
 * @Version 1.0
 **/
@Controller
public class BTypeController {

    /*
页面跳转
*/

    /**
     * @return
     * @Description:To：类型添加页面
     */
    @GetMapping("/type_add.html")
    public String type_add() {
        return "type/type_add";
    }

    /**
     * @return
     * @Description:To:类型列表页面
     */
    @GetMapping("/type_list.html")
    public String type_list() {
        return "type/type_list";
    }
}
