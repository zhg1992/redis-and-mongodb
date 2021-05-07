package com.example.redismongodb.service;

import com.example.redismongodb.dao.BookDao;
import com.example.redismongodb.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "c1")
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    // @Cacheable
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Cacheable(keyGenerator = "myKeyGenerator")
    public Book findById(Integer id) {
        Optional<Book> optional = bookDao.findById(id);
        return optional.orElse(null);
    }

    public void addBook(Book book) {
        bookDao.insert(book);
    }

    // 更新原数据及缓存
    @CachePut(keyGenerator = "myKeyGenerator")
    public void updateBook(Book book) {
        Query query = new Query(Criteria.where("id").is(book.getId()));
        Update update = new Update().set("name", book.getName()).set("author", book.getAuthor());
        mongoTemplate.updateFirst(query, update, Book.class);
    }

    // 删除数据同时删除缓存数据
    @CacheEvict
    public void deleteById(Integer id) {
        bookDao.deleteById(id);
    }

}
