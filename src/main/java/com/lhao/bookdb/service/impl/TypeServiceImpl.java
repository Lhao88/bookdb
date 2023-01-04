package com.lhao.bookdb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhao.bookdb.bean.Type;
import com.lhao.bookdb.mapper.TypeMapper;
import com.lhao.bookdb.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
        implements TypeService {

    @Resource
    TypeMapper typeMapper;

    @Override
    public PageInfo<Type> getPage(Integer pageNum, Integer limit) {
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(pageNum, limit);
        List<Type> typeList = typeMapper.selectList(null);
        PageInfo<Type> pageInfo = new PageInfo<>(typeList);
        return pageInfo;
    }
}




