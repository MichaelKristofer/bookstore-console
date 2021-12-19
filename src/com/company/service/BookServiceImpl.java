package com.company.service;

import com.company.entity.Author;
import com.company.entity.Book;
import com.company.storage.BookStorage;
import com.company.storage.InMemoryBookStorage;

public class BookServiceImpl implements BookService {

    private BookStorage bookStorage = new InMemoryBookStorage();

    @Override
    public boolean save(Book book) {
        if (bookStorage.contains(book.getTitle())) {
            return false;
        } else {
            bookStorage.save(book);
            return true;
        }
    }

    @Override
    public void delete(int id) {
        if (bookStorage.contains(id)) {
            bookStorage.delete(id);
        }
    }

    @Override
    public String updateTitle(int id, String title) {
        if (bookStorage.contains(id)) {
            return bookStorage.updateTitle(id, title);
        }
        return null;
    }

    @Override
    public String updateDescription(int id, String description) {
        if (bookStorage.contains(id)){
            return bookStorage.updateDescription(id, description);
        }
        return null;
    }

    @Override
    public double updatePrice(int id, double price) {
        if (bookStorage.contains(id)){
            return bookStorage.updatePrice(id, price);
        }
        return 0;
    }

    @Override
    public Author updateAuthor(int id, Author author) {
        if (bookStorage.contains(id)) {
            return bookStorage.updateAuthor(id, author);
        }
        return null;
    }

    @Override
    public Book getById(int id) {
        if (bookStorage.contains(id))
            return bookStorage.getById(id);
        return null;
    }

    @Override
    public Book getByTitle(String title) {
        if (bookStorage.contains(title))
            return bookStorage.getByTitle(title);
        return null;
    }

    @Override
    public Book[] getAll() {
        return bookStorage.getAll();
    }

    @Override
    public Book[] getAllByAuthor(Author author) {
        return bookStorage.getAllByAuthor(author);
    }

    @Override
    public Book[] getAllByPrice(double price) {
        return bookStorage.getAllByPrice(price);
    }
}
