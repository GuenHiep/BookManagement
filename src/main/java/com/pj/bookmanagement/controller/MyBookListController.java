package com.pj.bookmanagement.controller;

import com.pj.bookmanagement.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {

    @Autowired
    private MyBookListService myBookListService; // Service để thực hiện các thao tác CRUD cho MyBookList

    // Xóa một cuốn sách khỏi danh sách của người dùng
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        myBookListService.deleteById(id);
        return "redirect:/my_books"; // Chuyển hướng người dùng đến trang danh sách sách của họ sau khi xóa sách
    }
}
