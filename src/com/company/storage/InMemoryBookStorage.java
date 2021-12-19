package com.company.storage;

import com.company.entity.Author;
import com.company.entity.Book;

public class InMemoryBookStorage implements BookStorage {
    private Book[] books = new Book[10];
    private int size;
    private static int incId = 1;

    @Override
    public void save(Book book) {
        book.setId(incId++);
        books[size++] = book;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getId() == id) {
                for (int j = i; j < books.length - 1; j++) {
                    books[j] = books[j + 1];
                }
                size--;
            }
        }
    }

    @Override
    public String updateTitle(int id, String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getId() == id) {
                String title1 = books[i].getTitle();
                books[i].setTitle(title);
                return title1;
            }
        }
        return null;
    }

    @Override
    public String updateDescription(int id, String description) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getId() == id) {
                String description1 = books[i].getDescription();
                books[i].setDescription(description);
                return description1;
            }
        }
        return null;
    }

    @Override
    public double updatePrice(int id, double price) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getId() == id) {
                double price1 = books[i].getPrice();
                books[i].setPrice(price);
                return price1;
            }
        }
        return 0;
    }

    @Override
    public Author updateAuthor(int id, Author author) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getId() == id) {
                Author author1 = books[i].getAuthor();
                books[i].setAuthor(author);
                return author1;
            }
        }
        return null;
    }

    @Override
    public Book getById(int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getId() == id) {
                return books[i];
            }
        }
        return null;
    }

    @Override
    public Book getByTitle(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    @Override
    public Book[] getAll() {
        Book[] newArr = new Book[size];
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                break;
            }
            newArr[i] = books[i];
        }
        return newArr;
    }

    @Override
    public Book[] getAllByAuthor(Author author) {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getAuthor().equals(author)) {
                count++;
            }
        }
        Book[] newArr = new Book[count];
        for (int i = 0, j = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getAuthor().equals(author)) {
                newArr[j++] = books[i];
            }
        }
        return newArr;
    }

    @Override
    public Book[] getAllByPrice(double price) {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getPrice() == price) {
                count++;
            }
        }
        Book[] newArr = new Book[count];
        for (int i = 0, j = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getPrice() == price) {
                newArr[j++] = books[i];
            }
        }
        return newArr;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
