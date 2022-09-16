package com.lhao.bookdb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhao.bookdb.bean.Member;
import com.lhao.bookdb.service.MemberService;
import com.lhao.bookdb.mapper.MemberMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
    implements MemberService{

}




