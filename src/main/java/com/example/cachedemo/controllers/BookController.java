package com.example.cachedemo.controllers;

import com.example.cachedemo.dto.Book;
import com.example.cachedemo.service.BookService;
import com.example.cachedemo.service.NumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final NumberService numberService;
    private final BookService bookService;

    public BookController(NumberService numberService, BookService bookService) {
        this.numberService = numberService;
        this.bookService = bookService;
    }

    @GetMapping( path = "/number/square/{number}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public String test(
            @PathVariable( value = "number", required = true ) Integer number) throws InterruptedException {
        logger.info("Received request to get square of:{}", number);
        Integer value = numberService.getValue(number);
        logger.info("Return response after getting the square of:{} is:{}", number, value);
        return String.valueOf(value);
    }

    @PostMapping(path = "/book",
               produces = MediaType.APPLICATION_JSON_VALUE )
    public Book addBook(@RequestBody Book book) throws InterruptedException {
        return bookService.addBook(book);
    }

    @PutMapping(path = "/book",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public Book updateBook(@RequestBody Book book) throws InterruptedException {
        return bookService.updateBook(book);
    }

    @DeleteMapping(path = "/book/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public String deleteBook(@PathVariable long id) throws InterruptedException {
        return bookService.deleteBook(id);
    }

    @GetMapping(path = "/book/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public Book getBook(@PathVariable long id) throws InterruptedException {
        return bookService.getBook(id);
    }

}
