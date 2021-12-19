package com.company.service;

import com.company.entity.*;

public interface OrderService {

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
}
