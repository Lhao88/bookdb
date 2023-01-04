package com.lhao.bookdb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhao.bookdb.bean.Member;
import com.lhao.bookdb.mapper.MemberMapper;
import com.lhao.bookdb.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
        implements MemberService {

    @Resource
    MemberMapper memberMapper;


    @Override
    public PageInfo getPage(Integer pageNum, Integer limit) {
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(pageNum, limit);
        QueryWrapper wrapper = new QueryWrapper();
        List list = memberMapper.selectList(wrapper);
        return new PageInfo<Member>(list);

    }
}




