package com.catalin.demoProject.service;

import com.catalin.demoProject.dao.BookDao;
import com.catalin.demoProject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public int save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book get(int id) {
        return bookDao.get(id);
    }

    @Override
    public List<Book> list() {
        return bookDao.list();
    }

    @Transactional
    @Override
    public void update(int id, Book book) {
        bookDao.update(id, book);
    }

    @Transactional
    @Override
    public void delete(int id) {
        bookDao.delete(id);
    }
}
