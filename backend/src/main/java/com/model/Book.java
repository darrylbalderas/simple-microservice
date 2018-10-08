package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Book {
    @JsonProperty
    private String id;
    @JsonProperty
    private String title;
    @JsonProperty
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book() {
        super();
    }
}
