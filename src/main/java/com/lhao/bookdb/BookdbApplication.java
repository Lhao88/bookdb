package com.lhao.bookdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lhao.bookdb.mapper")
@SpringBootApplication
public class BookdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookdbApplication.class, args);
    }

}
