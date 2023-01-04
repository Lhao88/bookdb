package com.lhao.bookdb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.lhao.bookdb.bean.Member;
import com.lhao.bookdb.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MemberController
 * @Description :
 * @Author 小豪
 * @Date 2022/9/15 21:38
 * @Version 1.0
 **/
@Slf4j
@Controller
public class MemberController {

    @Resource
    MemberService memberService;


    /*
    页面跳转
     */

    /**
     * @return
     * @Description:To：添加会员
     */
    @RequestMapping("/mem_add.html")
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

    @RequestMapping("/mem_modify.html")
    public String mem_modify() {
        return "member/mem_modify";
    }

    /**
     * @return
     * @Description:To：会员充值
     */
    @RequestMapping("/mem_recharge.html")
    public String mem_recharge() {
        return "member/mem_recharge";
    }


    /**
     * @return
     * @Description:添加会员
     */
    @PostMapping("/member")
    public String addMember(Member member,
                            @RequestParam("pwd2") String pwd2,
                            HttpServletRequest request) throws ParseException {
        log.info("用户:{}", member);
        log.info(pwd2);
        if (member.getPwd().equals(pwd2)) {//两次密码输入一致
            //添加注册时间
            LocalDate localDate = LocalDate.now();
            String dateStr = localDate.toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);
            long time = date.getTime();
            member.setRegdate(new java.sql.Date(time));
            //添加会员
            memberService.save(member);
            return "redirect:/mem_add.html";
        } else { //返回错误信息
            request.setAttribute("msg", "两次密码输入不一致");
            return "forward:/mem_add.html";
        }
    }

    /**
     * @return
     * @Description:返回员工列表
     */

    @GetMapping("/member/page")
    @ResponseBody
    public Map<String, Object> getMemberList(@RequestParam("pageNum") Integer pageNum) {

//        ArrayList<Member> list = (ArrayList<Member>) memberService.list();
        PageInfo page = memberService.getPage(pageNum, 4);
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", page);
        return map;
    }


    /**
     * @return
     * @Description:会员充值
     */
    @PostMapping("/member/money")
    public String updateBalance(@RequestParam("idNumber") String idNumber,
                                @RequestParam("amount") String amount,
                                HttpServletRequest request) {
        //根据身份证号查询会员
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id_number", idNumber);
        Member member = memberService.getOne(queryWrapper);
        if (member == null) { //会员不存在，返回错误信息
            request.setAttribute("msg", "身份证号不存在");
            return "forward:/mem_recharge.html";
        }
        //更新会员余额
        Double balance = member.getBalance();
        BigDecimal bigBalance = new BigDecimal(balance);
        BigDecimal bigAmount = new BigDecimal(amount);
        double newBalance = bigBalance.add(bigAmount).doubleValue();
        member.setBalance(newBalance);
        memberService.saveOrUpdate(member);
        request.setAttribute("msg", "充值成功");
        return "forward:/mem_recharge.html";
    }

    /**
     * @return :
     * @Description:根据idNumber删除用户
     */
    @DeleteMapping("/member")
    public void deleteMemberByIdNumber(@RequestParam("id") Integer id) {
        memberService.removeById(id);
    }


    /**
     * @return：跳转到会员修改页面
     * @Description:根据id查询会员信息
     */
    @GetMapping("/member/{id}")
    public String getMember(@PathVariable("id") Integer id,
                            HttpSession session) {
        Member member = memberService.getById(id);
        session.setAttribute("member", member);
        return "forward:/mem_modify.html";
    }

    /**
     * @return
     * @Description:更新会员信息
     */
    @PutMapping("/member")
    public String updateMember(Member member) {
        memberService.saveOrUpdate(member);
        return "redirect:/mem_list.html";
    }
}
