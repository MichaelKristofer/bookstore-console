package com.company.entity;

import java.util.Arrays;

public class Order {
    private int id;
    private User user;
    private Address address;
    private Store store;
    private Book[] books;

    public Order() {
    }

    public Order(User user, Address address, Store store, Book[] books) {
        this.user = user;
        this.address = address;
        this.store = store;
        this.books = books;
    }

    public Order(int id, User user, Address address, Store store, Book[] books) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.store = store;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks() {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", address=" + address +
                ", store=" + store +
                ", books=" + Arrays.toString(books) +
                '}';
    }
}
