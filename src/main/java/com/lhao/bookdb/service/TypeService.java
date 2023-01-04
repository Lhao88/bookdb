package com.lhao.bookdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lhao.bookdb.bean.Type;

/**
 *
 */
public interface TypeService extends IService<Type> {

    PageInfo<Type> getPage(Integer pageNum, Integer limit);
}
