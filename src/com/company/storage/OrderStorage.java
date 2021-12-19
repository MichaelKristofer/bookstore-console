package com.company.storage;

import com.company.entity.*;

public interface OrderStorage {
    boolean save(Order order);

    User updateUser(int id, User user);

    Address updateAddress(int id, Address address);

    Store updateStore(int id, Store store);

    void addBook(int id, Book book);

    Book deleteBook(int id, int bookId);

    void delete(int id);

    void delete(Order order);

    Book[] getAllBooks(int id);

    Order[] getAll();

    Order[] getAllByUser(User user);

    Order[] getAllByAddress(Address address);

    Order[] getAllByStore(Store store);

    Order getById(int id);

    boolean contains(int id);

    boolean contains(Order order);

    boolean contains(User user);

    boolean contains(Address address);

    boolean contains(Store store);
}
