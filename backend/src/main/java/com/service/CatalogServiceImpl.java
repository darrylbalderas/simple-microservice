package com.service;

import com.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    private HashMap<String, Book> books;
    private long numBooks;

    public CatalogServiceImpl() {
        this.books = new HashMap<>();
        numBooks = 0;
    }

    public void createBook(Book book) {
        book.setId(Long.toString(numBooks));
        books.put(book.getId(), book);
        numBooks++;
    }

    public Book getBook(String id) {
        return books.get(id);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    public Boolean isBookIdInCatalog(String id) {
        return books.containsKey(id);
    }
}
