package com.task.Library.Management.System.controllers;

import com.task.Library.Management.System.models.Book;
import com.task.Library.Management.System.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/books")
public class BookController {
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Book> getAll(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Book getOne(@PathVariable long id){
        return bookService.getBook(id);
    }
    @PostMapping("")
    @ResponseBody
    public String create(@RequestParam String title,@RequestParam String isbn,@RequestParam String author,@RequestParam int publication_year){
        return bookService.create(title,author,isbn,publication_year);
    }
    @PostMapping("/{id}")
    @ResponseBody
    public String update(@PathVariable long id,@RequestParam String title,@RequestParam String isbn,@RequestParam String author,@RequestParam int publication_year) {
        return bookService.update(id,title,author,isbn,publication_year);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        return bookService.delete(id);
    }
}
