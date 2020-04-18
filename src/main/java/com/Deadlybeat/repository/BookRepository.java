package com.Deadlybeat.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.Deadlybeat.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
