package com.example.learn.service;


import com.example.learn.model.Book;
import com.example.learn.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAllByOrderByTitleAsc();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book _book = bookRepository.findById(id).orElse(null);
        if (_book != null) {
            _book.setAuthor(book.getAuthor());
            _book.setCategory(book.getCategory());
            _book.setDescription(book.getDescription());
            _book.setStatus(book.getStatus());
            _book.setTitle(book.getTitle());
            _book.setImageUrl(book.getImageUrl());
            _book.setPageCount(book.getPageCount());
            _book.setPublicId(book.getPublicId());
            _book.setReleaseDate(book.getReleaseDate());
            System.out.println(_book);
            return bookRepository.save(_book);
        }

        return _book;
    }

    // Other methods
}
