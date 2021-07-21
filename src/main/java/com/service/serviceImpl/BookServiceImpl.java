package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.model.Book;
import com.repository.BookRepository;
import com.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl  implements BookService{
    
    @Autowired
    private BookRepository repo;

    @Override
    public Book saveBook(Book book){
        return repo.save(book);
    }

    @Override
    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list = new ArrayList<Book>();
        list=(ArrayList<Book>) repo.findAll();
        return list;
    }
}
