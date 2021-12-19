package com.company.storage;

import com.company.entity.*;

public class InMemoryOrderStorage implements OrderStorage {
    private int incId = 0;
    private int size = 0;
    Order[] ordeR = new Order[10];

    @Override
    public boolean save(Order order) {
        order.setId(incId++);
        for (int i = 0; i < ordeR.length; i++) {
            if (ordeR[i] == null) {
                ordeR[i] = order;
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public User updateUser(int id, User user) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getId() == id) {
                User user1 = ordeR[i].getUser();
                ordeR[i].setUser(user);
                return user1;
            }
        }
        return user;
    }

    @Override
    public Address updateAddress(int id, Address address) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getId() == id) {
                Address address1 = ordeR[i].getAddress();
                ordeR[i].setAddress(address);
                return address1;
            }
        }
        return address;
    }

    @Override
    public Store updateStore(int id, Store store) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getId() == id) {
                Store store1 = ordeR[i].getStore();
                ordeR[i].setStore(store);
                return store1;
            }
        }
        return store;
    }

    @Override
    public void addBook(int id, Book book) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getId() == id) {
                Book[] books = ordeR[i].getBooks();
                for (int i1 = 0; i1 < books.length; i1++) {
                    if (books[i1] == null) {
                        books[i1] = book;
                        break;
                    }
                }
                break;
            }
        }
    }

    @Override
    public Book deleteBook(int id, int bookId) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getId() == id) {
                Book[] books = ordeR[i].getBooks();
                for (int i1 = 0; i1 < books.length; i1++) {
                    if (books[i1].getId() == bookId) {
                        for (int i2 = i1; i2 < books.length - 1; i2++) {
                            books[i2] = books[i2 + 1];
                        }
                        break;
                    }
                }
                break;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getId() == id) {
                for (int j = i; j < ordeR.length - 1; j++) {
                    ordeR[j] = ordeR[j + 1];
                }
                break;
            }
        }
    }

    @Override
    public void delete(Order order) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i] == order) {
                for (int j = i; j < ordeR.length - 1; j++) {
                    ordeR[j] = ordeR[j + 1];
                }
                break;
            }
        }
    }

    @Override
    public Book[] getAllBooks(int id) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getId() == id) {
                return ordeR[i].getBooks();
            }
        }
        return null;
    }

    @Override
    public Order[] getAll() {
        int size1 = 0;
        for (int i = 0; i < size; i++) {
            if (ordeR[i] != null) {
                size1++;
            }
        }
        Order[] allOrders = new Order[size1];
        for (int i = 0, j = 0; i < size; i++) {
            if (ordeR[i] != null) {
                allOrders[j++] = ordeR[i];
            }
        }
        return allOrders;
    }

    @Override
    public Order[] getAllByUser(User user) {
        int size1 = 0;
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getUser().equals(user)) {
                size1++;
            }
        }
        Order[] allUsersOrders = new Order[size1];
        for (int i = 0, j = 0; i < size; i++) {
            if (ordeR[i].getUser().equals(user)) {
                allUsersOrders[j++] = ordeR[i];
            }
        }
        return allUsersOrders;
    }

    @Override
    public Order[] getAllByAddress(Address address) {
        int size1 = 0;
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getAddress().equals(address)) {
                size1++;
            }
        }
        Order[] allAddressOrders = new Order[size1];
        for (int i = 0, j = 0; i < size; i++) {
            if (ordeR[i].getAddress().equals(address)) {
                allAddressOrders[j++] = ordeR[i];
            }
        }
        return allAddressOrders;
    }

    @Override
    public Order[] getAllByStore(Store store) {
        int size1 = 0;
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getStore().equals(store)) {
                size1++;
            }
        }
        Order[] allStoreOrders = new Order[size1];
        for (int i = 0, j = 0; i < size; i++) {
            if (ordeR[i].getStore().equals(store)) {
                allStoreOrders[j++] = ordeR[i];
            }
        }
        return allStoreOrders;
    }

    @Override
    public Order getById(int id) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getId() == id) {
                return ordeR[i];
            }
        }
        return null;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Order order) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].equals(order)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(User user) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Address address) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getAddress().equals(address)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Store store) {
        for (int i = 0; i < size; i++) {
            if (ordeR[i].getStore().equals(store)) {
                return true;
            }
        }
        return false;
    }
}
