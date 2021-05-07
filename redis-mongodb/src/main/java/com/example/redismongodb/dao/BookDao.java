package com.example.redismongodb.dao;

import com.example.redismongodb.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookDao extends MongoRepository<Book, Integer> {
}
