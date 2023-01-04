package com.lhao.bookdb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhao.bookdb.bean.Book;
import com.lhao.bookdb.mapper.BookMapper;
import com.lhao.bookdb.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
        implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public PageInfo<Book> getPage(Integer pageNum, int limit) {

        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(pageNum, limit);
        List<Book> bookList = bookMapper.selectList(null);
        return new PageInfo<>(bookList);

    }
}




