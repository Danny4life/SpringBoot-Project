package com.example.springbootproject.controller;

import com.example.springbootproject.entity.Book;
import com.example.springbootproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    BookService service;

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("books", service.findAllBooks());
        return "all-books";
    }


    @GetMapping("/edit/{id}")
    public String lunchEditPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", service.findBookById(id));
        return "edit-book";

    }

    @PostMapping("/updatebook")
    public String updateBook(Book book){
        service.updateBooks(book);
        return "redirect:/";
    }

    @PostMapping("/addbook")
    public String createBook(Book book){
        service.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String lunchAddBookPage(Model model){
        model.addAttribute("book", new Book());
        return "add-book";

    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id){
        service.deleteBook(id);
        return "redirect:/";
    }
    @GetMapping("/test")
    public String test(){
        Book st = new Book();
        st.setId(1);
        st.setAuthor("segun");
        st.setName("java");
        st.setNoOfPages(299);
        st.setPublication("crown");
        service.addBook(st);
        return "index";
    }

}
