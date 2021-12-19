package com.company.console;

import com.company.entity.Book;
import com.company.service.BookService;
import com.company.service.BookServiceImpl;

public class Basket {
    private BookService bookService = new BookServiceImpl();
    private Book[] books = new Book[10];
    private int size;

    public void add(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                size++;
                break;
            }
        }
    }

    public void delete(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book)) {
                for (int j = i; j < books.length - 1; j++) {
                    books[j++] = books[i];
                }
                size--;
                break;
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Book[] getBooks() {
        int g = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                g++;
            }
        }
        Book[] allBookInBasket = new Book[g];
        for (int i = 0, f = 0; i < books.length; i++) {
            if (books[i] != null) {
                books[i] = allBookInBasket[f];
            }
        }
        return null;
    }
}
