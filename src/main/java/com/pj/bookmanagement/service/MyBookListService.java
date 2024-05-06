package com.pj.bookmanagement.service;

import com.pj.bookmanagement.model.MyBookList;
import com.pj.bookmanagement.repository.MyBookListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBookListRepository myBookListRepository; // Repository để thực hiện các thao tác truy vấn với cơ sở dữ liệu cho MyBookList

    // Lưu một cuốn sách vào danh sách của người dùng
    public MyBookList saveMyBook(MyBookList bookList) {
        return myBookListRepository.save(bookList);
    }

    // Lấy danh sách tất cả các cuốn sách từ danh sách của người dùng
    public List<MyBookList> getAllMyBooks(){
        return myBookListRepository.findAll();
    }

    // Xóa một cuốn sách khỏi danh sách của người dùng dựa trên ID
    public void deleteById(int id) {
        myBookListRepository.deleteById(id);
    }
}
