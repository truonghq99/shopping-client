package com.service;

import java.util.ArrayList;

import com.model.Book;

import org.springframework.stereotype.Service;

@Service
public interface BookService {
    
    public Book saveBook(Book book);

    public ArrayList<Book> getAllBook();
}
