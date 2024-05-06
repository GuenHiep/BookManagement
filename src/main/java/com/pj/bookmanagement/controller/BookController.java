package com.pj.bookmanagement.controller;

import com.pj.bookmanagement.model.Book;
import com.pj.bookmanagement.model.MyBookList;
import com.pj.bookmanagement.service.BookService;
import com.pj.bookmanagement.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService; // Service để thực hiện các thao tác CRUD cho Book

    @Autowired
    private MyBookListService myBookListService; // Service để thực hiện các thao tác CRUD cho MyBookList

    // Trang chủ
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // Trang đăng ký sách mới
    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    // Lấy tất cả các sách có sẵn
    @GetMapping("/available_books")
    public String getAllBook(Model model) {
        model.addAttribute("book", bookService.getAllBook());
        return "bookList";
    }

    // Thêm sách mới
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/available_books";
    }

    // Lấy danh sách các sách của người dùng
    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        model.addAttribute("book", myBookListService.getAllMyBooks());
        return "myBooks";
    }

    // Thêm một cuốn sách vào danh sách của người dùng
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
        myBookListService.saveMyBook(myBookList);
        return "redirect:/my_books";
    }

    // Chỉnh sửa thông tin của một cuốn sách
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "bookEdit";
    }

    // Xóa một cuốn sách
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}
