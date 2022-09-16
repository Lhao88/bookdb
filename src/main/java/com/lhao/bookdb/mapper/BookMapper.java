package com.lhao.bookdb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhao.bookdb.bean.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity com.lhao.bookdb.bean.Book
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}




