package com.example.springbootproject.service;

import com.example.springbootproject.entity.Book;
import com.example.springbootproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    // find all books method
    public List<Book> findAllBooks(){
        return (List<Book>) repository.findAll();
    }

    // find books by id method (READ)
    public Book findBookById(int id){
        Optional<Book> result = repository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return new Book();
    }

    // add books method (CREATE)
    public Book addBook(Book book)  {
        return repository.save(book);
    }

    //update books method (UPDATE)
    public Book updateBooks(Book book){
        Optional<Book> result = repository.findById(book.getId());
        Book existing = result.get();
        existing.setAuthor(book.getAuthor());
        existing.setName(book.getName());
        existing.setNoOfPages(book.getNoOfPages());
        existing.setPublication(book.getPublication());
        return repository.save(existing);

    }

    //delete book method (DELETE)
    public void deleteBook(int id){
        repository.deleteById(id);
    }
}
