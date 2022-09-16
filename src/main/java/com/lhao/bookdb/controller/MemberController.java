package com.lhao.bookdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName MemberController
 * @Description :
 * @Author 小豪
 * @Date 2022/9/15 21:38
 * @Version 1.0
 **/
@Controller
public class MemberController {

    /*
    页面跳转
     */

    /**
     * @return
     * @Description:To：添加会员
     */
    @GetMapping("/mem_add.html")
    public String mem_add() {
        return "member/mem_add";
    }

    /**
     * @return
     * @Description:To：会员管理
     */
    @GetMapping("/mem_list.html")
    public String mem_list() {
        return "member/mem_list";
    }

    /**
     * @return
     * @Description:To：会员充值
     */
    @GetMapping("/mem_recharge.html")
    public String mem_recharge() {
        return "member/mem_recharge";
    }


}
