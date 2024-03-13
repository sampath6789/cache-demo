package com.example.cachedemo.service;

import com.example.cachedemo.dto.Book;

public interface BookService {
    Book addBook(Book book) throws InterruptedException;
    Book updateBook(Book book) throws InterruptedException;
    Book getBook(long id) throws InterruptedException;
    String deleteBook(long id) throws InterruptedException;
}
