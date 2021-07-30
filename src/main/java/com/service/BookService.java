package com.service;

import java.util.ArrayList;

import com.model.Book;

import org.springframework.stereotype.Service;

@Service
public interface BookService {
    
    public Book saveBook(Book book);

    public ArrayList<Book> getAllBook();

    public void deleteBook(int id);
    
    public void updateBook(Book book, int id);

    public Book findBookById(int id);
    
}
