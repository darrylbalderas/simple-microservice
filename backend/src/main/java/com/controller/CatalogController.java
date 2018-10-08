package com.controller;

import com.model.Book;
import com.service.CatalogService;
import com.service.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatalogController {

    private CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService service) {
        this.catalogService = service;
        catalogService.createBook(new Book("Huckleberry fin","Mark Twain"));
        catalogService.createBook(new Book("Captain Underpants 1","Dav Pilkey"));
        catalogService.createBook(new Book("Captain Underpants 2","Dav Pilkey"));
        catalogService.createBook(new Book("Captain Underpants 3","Dav Pilkey"));
        catalogService.createBook(new Book("Tom Sawyer","Mark Twain"));
    }

    @RequestMapping("/")
    public ResponseEntity<String> getHomePage() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }


    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        if(book == null || book.getAuthor() == null || book.getTitle() == null) {
            return new ResponseEntity<>(book, HttpStatus.BAD_REQUEST);
        }
        catalogService.createBook(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(catalogService.getBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBooks(@PathVariable String id) {
        if(!catalogService.isBookIdInCatalog(id)) {
            return new ResponseEntity<>(new Book(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(catalogService.getBook(id), HttpStatus.OK);
    }
}
