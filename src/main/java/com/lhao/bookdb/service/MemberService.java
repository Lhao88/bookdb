package com.lhao.bookdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lhao.bookdb.bean.Member;

/**
 *
 */
public interface MemberService extends IService<Member> {
    PageInfo getPage(Integer pageNum, Integer limit);
}
