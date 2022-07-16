package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
