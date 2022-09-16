package com.lhao.bookdb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhao.bookdb.bean.Book;
import com.lhao.bookdb.mapper.BookMapper;
import com.lhao.bookdb.service.BookService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
        implements BookService {


}




