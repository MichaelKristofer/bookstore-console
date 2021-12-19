package com.company.service;

import com.company.entity.Address;
import com.company.entity.User;
import com.company.storage.InMemoryUserStorage;
import com.company.storage.UserStorage;

public class UsersServiceImpl implements UsersService{
    private UserStorage userStorage = new InMemoryUserStorage();
    @Override
    public boolean save(User user) {
        if (userStorage.contains(user)) {
            return false;
        } else {
            userStorage.save(user);
            return true;
        }
    }

    @Override
    public String updateName(int id, String name) {
        if (userStorage.contains(id)) {
            userStorage.updateName(id, name);
        }
        return null;
    }

    @Override
    public String updatePassword(int id, String password) {
        if (userStorage.contains(id)) {
            userStorage.updatePassword(id, password);
        }
        return null;
    }

    @Override
    public Address updateAddress(int id, Address address) {
        if (userStorage.contains(id)) {
            userStorage.updateAddress(id, address);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        if (userStorage.contains(id)) {
            userStorage.delete(id);
        }

    }

    @Override
    public void delete(User user) {
        if (userStorage.contains(user)) {
            userStorage.delete(user);
        }
    }

    @Override
    public User[] getAll() {
        return userStorage.getAll();
    }

    @Override
    public User[] getAllByName(String name) {
        return userStorage.getAllByName(name);
    }

    @Override
    public User getById(int id) {
        if (userStorage.contains(id)) {
            return userStorage.getById(id);
        }
        return null;
    }

    @Override
    public User getByLogin(String login) {
        if (userStorage.contains(login)) {
            return userStorage.getByLogin(login);
        }
        return null;
    }

    @Override
    public User getByAddress(Address address) {
        if (userStorage.contains(address)) {
            return userStorage.getByAddress(address);
        }
        return null;
    }
}
