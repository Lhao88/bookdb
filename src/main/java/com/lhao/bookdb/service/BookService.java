package com.lhao.bookdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lhao.bookdb.bean.Book;

/**
 *
 */
public interface BookService extends IService<Book> {

    PageInfo<Book> getPage(Integer pageNum, int limit);
}
