package com.company.service;

import com.company.entity.*;
import com.company.storage.OrderStorage;
import com.company.storage.InMemoryOrderStorage;

public class OrderServiceImpl implements OrderService {
    OrderStorage orderStorage = new InMemoryOrderStorage();
        @Override
        public boolean save(Order order) {
            if (orderStorage.contains(order)) {
                return false;
            } else {
                orderStorage.save(order);
                return true;
            }
        }

        @Override
        public User updateUser(int id, User user) {
            if (orderStorage.contains(id)) {
                return orderStorage.updateUser(id, user);
            }
            return null;
        }

        @Override
        public Address updateAddress(int id, Address address) {
            if (orderStorage.contains(id)) {
                return orderStorage.updateAddress(id, address);
            }
            return null;
        }

        @Override
        public Store updateStore(int id, Store store) {
            if (orderStorage.contains(id)) {
                return orderStorage.updateStore(id, store);
            }
            return null;
        }

        @Override
        public void addBook(int id, Book book) {
            if (orderStorage.contains(id)) {
                orderStorage.addBook(id, book);
            }
        }

        @Override
        public Book deleteBook(int id, int bookId) {
            if (orderStorage.contains(id)) {
                return orderStorage.deleteBook(id, bookId);
            }
            return null;
        }

        @Override
        public void delete(int id) {
            if (orderStorage.contains(id)) {
                orderStorage.delete(id);
            }

        }

        @Override
        public void delete(Order order) {
            if (orderStorage.contains(order)) {
                orderStorage.delete(order);
            }
        }

        @Override
        public Book[] getAllBooks(int id) {
            if (orderStorage.contains(id)) {
                return orderStorage.getAllBooks(id);
            }
            return null;
        }

        @Override
        public Order[] getAll() {
            return orderStorage.getAll();
        }

        @Override
        public Order[] getAllByUser(User user) {
            if (orderStorage.contains(user)) {
                return orderStorage.getAllByUser(user);
            }
            return null;
        }

        @Override
        public Order[] getAllByAddress(Address address) {
            if (orderStorage.contains(address)) {
                return orderStorage.getAllByAddress(address);
            }
            return null;
        }

        @Override
        public Order[] getAllByStore(Store store) {
            if (orderStorage.contains(store)) {
                return orderStorage.getAllByStore(store);
            }
            return null;
        }

        @Override
        public Order getById(int id) {
            if (orderStorage.contains(id)) {
                return orderStorage.getById(id);
            }
            return null;
        }
    }
