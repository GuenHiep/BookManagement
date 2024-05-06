package com.pj.bookmanagement.repository;

import com.pj.bookmanagement.model.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookListRepository extends JpaRepository<MyBookList,Integer> {
}
