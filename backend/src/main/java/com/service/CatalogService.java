package com.service;

import com.model.Book;

import java.util.List;

public interface CatalogService {
    void createBook(Book book);
    Book getBook(String id);
    List<Book> getBooks();
    Boolean isBookIdInCatalog(String id);
}
