package com.catalin.demoProject.controller;

import com.catalin.demoProject.model.Book;
import com.catalin.demoProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService){
        this.bookService=bookService;
    }

    /* Add a new book */
    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book){
        int id = bookService.save(book);
        return ResponseEntity.ok().body("The new book has been saved with id = " + id);
    }

    /* Get a book by id */
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") int id){
        Book book = bookService.get(id);
        return ResponseEntity.ok().body(book);
    }

    /* Get all books */
    @GetMapping("/book")
    public ResponseEntity<List<Book>> list(){
        List<Book> books = bookService.list();
        return ResponseEntity.ok().body(books);
    }

    /* Update a book by ID */
    @PutMapping("/book/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Book book){
        bookService.update(id, book);
        return ResponseEntity.ok().body("Book has been updated successfully.");
    }

    /* Delete a book by ID */
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        bookService.delete(id);
        return ResponseEntity.ok().body("Book with id = " + id + " has been deleted.");
    }
}
