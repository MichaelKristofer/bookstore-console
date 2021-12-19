package com.company.storage;

import com.company.entity.Address;
import com.company.entity.User;

public class InMemoryUserStorage implements UserStorage {
    private User[] users = new User[10];
    private int size;
    private int incId = 1;

    public InMemoryUserStorage() {
        save(new User("User", "user", "user", new Address("test", 22), "USER"));
        save(new User("Admin", "admin", "admin", new Address("test2", 33), "ADMIN"));
    }

    @Override
    public boolean save(User user) {
        user.setId(incId++);
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public String updateName(int id, String name) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                String name1 = users[i].getName();
                users[i].setName(name);
                return name1;
            }
        }
        return name;
    }

    @Override
    public String updatePassword(int id, String password) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                String password1 = users[i].getPassword();
                users[i].setPassword(password);
                return password1;
            }
        }
        return password;
    }

    @Override
    public Address updateAddress(int id, Address address) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                Address address1 = users[i].getAddress();
                users[i].setAddress(address);
                return address1;
            }
        }
        return address;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    users[j] = users[i + 1];
                }
                size--;
                break;
            }
        }
    }

    @Override
    public void delete(User user) {
        for (int i = 0; i < size; i++) {
            if (users[i].equals(user)) {
                for (int j = i; j < size - 1; j++) {
                    users[j] = users[i + 1];
                }
                size--;
                break;
            }
        }
    }

    @Override
    public User[] getAll() {
        User[] arr = new User[size];
        for (int i = 0; i < size; i++) {
            arr[i] = users[i];
        }
        return arr;
    }

    @Override
    public User[] getAllByName(String name) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (users[i].getName().equals(name)){
                count++;
            }
        }
        User[] arr = new User[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (users[i].getName().equals(name))
                arr[j++] = users[i];
        }
        return arr;
    }

    @Override
    public User getById(int id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        return null;
    }

    @Override
    public User getByLogin(String login) {
        for (int i = 0; i < size; i++) {
            if (users[i].getLogin().equals(login)) {
                return users[i];
            }
        }
        return null;
    }

    @Override
    public User getByAddress(Address address) {
        for (int i = 0; i < size; i++) {
            if (users[i].getAddress().equals(address)) {
                return users[i];
            }
        }
        return null;
    }

    @Override
    public boolean contains(Address address) {
        for (int i = 0; i < size; i++) {
            if (users[i].getAddress().equals(address)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(User user) {
        for (int i = 0; i < size; i++) {
            if (users[i] == user) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String login) {
        for (int i = 0; i < size; i++) {
            if (users[i].getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
