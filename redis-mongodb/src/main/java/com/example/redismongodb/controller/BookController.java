package com.example.redismongodb.controller;

import com.example.redismongodb.dao.BookDao;
import com.example.redismongodb.entity.Book;
import com.example.redismongodb.entity.RespBean;
import com.example.redismongodb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/")
    public List<Book> findAll() {
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public Book find(@PathVariable("id") Integer id) {
        return bookService.findById(id);
    }

    @PostMapping("/")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("/")
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
    }
}
