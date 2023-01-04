package com.lhao.bookdb.controller;

import com.github.pagehelper.PageInfo;
import com.lhao.bookdb.bean.Book;
import com.lhao.bookdb.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BookController
 * @Description :
 * @Author 小豪
 * @Date 2022/9/15 21:44
 * @Version 1.0
 **/
@Slf4j
@Controller
public class BookController {

    @Resource
    BookService bookService;

    /*
页面跳转
 */

    /**
     * @return
     * @Description:To:添加列表
     */
    @GetMapping("/book_add.html")
    public String book_add() {
        return "book/book_add";
    }

    /**
     * @return
     * @Description:To:图书列表
     */
    @RequestMapping("/book_list.html")
    public String book_list() {
        return "book/book_list";
    }

    /**
     * @return
     * @Description:To:图书详情
     */
    @GetMapping("/book_details.html")
    public String book_details() {
        return "book/book_details";
    }

    /**
     * @return
     * @Description:To:图书修改
     */
    @RequestMapping("/book_modify.html")
    public String book_modify() {
        return "book/book_modify";
    }

    /**
     * @return
     * @Description:获取图书信息
     */

    @ResponseBody
    @GetMapping("/book/page")
    public Map<String, Object> getBook(@RequestParam("pageNum") Integer pageNum) {
        PageInfo<Book> bookPageInfo = bookService.getPage(pageNum, 4);
        HashMap<String, Object> map = new HashMap<>();
        map.put("books", bookPageInfo);
        return map;
    }

    /**
     * @return
     * @Description:添加图书
     */
    @PostMapping("/book")
    public String addBook(MultipartFile photo) {
        String originalFilename = photo.getOriginalFilename();
        log.info(originalFilename);
        return null;
    }

    /**
     * @return
     * @Description:根据id查找图书
     */
    @GetMapping("/book/{id}")
    public String getBook(@PathVariable("id") Integer id,
                          HttpSession session) {
        Book book = bookService.getById(id);
        session.setAttribute("book", book);
        return "forward:/book_modify.html";
    }


    /**
     * @return
     * @Description:保存更改信息
     */
    @PutMapping("/book")
    public String update(Book book) {
        bookService.saveOrUpdate(book);
        return "forward:/book_list.html";
    }

    /**
     * @return
     * @Description:根据id删除图书
     */
    @ResponseBody
    @DeleteMapping("/book/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        bookService.removeById(id);
        return "ok";
    }

    /**
     * @return
     * @Description:返回图书详情
     */
    @GetMapping("/book/detail/{id}")
    public String getBookDetail(@PathVariable("id") Integer id,
                                HttpSession session) {
        Book book = bookService.getById(id);
        session.removeAttribute("book");
        session.setAttribute("book", book);
        return "forward:/book_details.html";
    }
}
