package com.pj.bookmanagement.service;

import com.pj.bookmanagement.model.Book;
import com.pj.bookmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository; // Repository để thực hiện các thao tác truy vấn với cơ sở dữ liệu cho Book

    // Lưu một cuốn sách mới hoặc cập nhật thông tin của một cuốn sách đã tồn tại
    public void save(Book book) {
        bookRepository.save(book);
    }

    // Lấy danh sách tất cả các cuốn sách từ cơ sở dữ liệu
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    // Lấy thông tin của một cuốn sách dựa trên ID
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Xóa một cuốn sách dựa trên ID
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
