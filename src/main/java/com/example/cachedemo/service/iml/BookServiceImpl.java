package com.example.cachedemo.service.iml;

import com.example.cachedemo.dto.Book;
import com.example.cachedemo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

private final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public Book addBook(Book book) throws InterruptedException {
        logger.info("adding book with id - "+book.getId());
        Thread.sleep(2000);
        return getBookObj();//return bookRepository.save(book);
    }

    @Override
    @CachePut(cacheNames = "books", key = "#book.id")
    public Book updateBook(Book book) throws InterruptedException {
        logger.info("updating book with id - "+book.getId());
        Thread.sleep(3000);
        return getBookObj();
    }

    @Override
    @CacheEvict(cacheNames = "books", key = "#id")
    public String deleteBook(long id) throws InterruptedException {
        logger.info("deleting the book with id" + id);
        Thread.sleep(1500);//bookRepository.deleteById(id);
        return "Book deleted";
    }

    @Override
    @Cacheable(cacheNames = "books", key = "#id")
    public Book getBook(long id) throws InterruptedException {
        logger.info("fetching book from db with id" + id);
        Thread.sleep(3000);
        return getBookObj();
    }

    private Book getBookObj() {
        Book book = new Book();
        book.setId(42);
        book.setName("reactive");
        book.setCategory("computer-science");
        book.setAuthor("DU ABC");
        book.setPublisher("India");
        book.setEdition("1st");
        return book;
    }
}
