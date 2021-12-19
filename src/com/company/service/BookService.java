package com.company.service;

import com.company.entity.Author;
import com.company.entity.Book;

public interface BookService {
    boolean save(Book book);

    void delete(int id);

    String updateTitle(int id, String title);

    String updateDescription(int id, String description);

    double updatePrice(int id, double price);

    Author updateAuthor(int id, Author author);

    Book getById(int id);

    Book getByTitle(String title);

    Book[] getAll();

    Book[] getAllByAuthor(Author author);

    Book[] getAllByPrice(double price);
}
