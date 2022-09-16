package com.lhao.bookdb;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhao.bookdb.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class BookdbApplicationTests {

    @Autowired
    BookMapper bookMapper;

    @Test
    void contextLoads() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.between("id", 9, 10);
        List list = bookMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

}
