package com.catalin.demoProject.service;

import com.catalin.demoProject.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    int save(Book book);
    Book get(int id);
    List<Book> list();
    void update(int id, Book book);
    void delete(int id);
}
