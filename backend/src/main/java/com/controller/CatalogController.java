package com.controller;

import com.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatalogController {

    @RequestMapping("/")
    public ResponseEntity<String> getHomePage() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("title1", "author1"));
        books.add(new Book("title2", "author2"));
        books.add(new Book("title3", "author3"));
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
