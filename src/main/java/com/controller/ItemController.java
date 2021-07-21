package com.controller;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;

import com.model.Book;
import com.model.Clothes;
import com.model.Electronics;

import com.service.BookService;
import com.service.ClothesService;
import com.service.ElectronicsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("item")
public class ItemController{
    @Autowired
    private BookService bookService;
    @Autowired
    private ClothesService clothesService;
    @Autowired
    private ElectronicsService electronicsService;

    @GetMapping("/createItem")
    public String showCreateItem(Model model, Book book, Clothes clothes, Electronics electronics){
        book = new Book();
        electronics = new Electronics();
        clothes= new Clothes();
        model.addAttribute("book", book);
        model.addAttribute("electronics", electronics);
        model.addAttribute("clothes", clothes);
        return "createItem";
    }
    @RequestMapping(value="/saveBook", method = RequestMethod.POST)
    public String createBook(Book book){
        bookService.saveBook(book);
        return "home_page";
    }
    @RequestMapping(value="/saveClothes", method = RequestMethod.POST)
    public String createClothes(Clothes clothes){
        clothesService.saveClothes(clothes);
        return "home_page";
    }
    @RequestMapping(value="/saveElectronics", method = RequestMethod.POST)
    public String createElectronics(Electronics electronics){
        electronicsService.saveElectronics(electronics);
        return "home_page";
    }

    @RequestMapping(value="/list-books")
    public String showListBooks(Book book,Model model, HttpSession session){
        ArrayList<Book> list= bookService.getAllBook();
        model.addAttribute("listbooks", list);
        session.setAttribute("listbooks",list);
        session.getAttribute("idBook");
        return "list_books";
        
    }
    @RequestMapping(value="list-books/details/{id}")
    public String showDetailBook(@PathVariable int id, HttpServletRequest request, Model model){
        ArrayList<Book> list= (ArrayList<Book>) request.getSession().getAttribute("listbooks");
        Book book= new Book();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==id){
                book.setTitle(list.get(i).getTitle());
                book.setAuthor(list.get(i).getAuthor());
                book.setPublisher(list.get(i).getPublisher());
                book.setPrice(list.get(i).getPrice());
                book.setMfgDate(list.get(i).getMfgDate());
                book.setCategory(list.get(i).getCategory());
                break;
            }
        }
        model.addAttribute("book", book);
        return "details_book";
    }
}

