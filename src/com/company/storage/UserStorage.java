package com.company.storage;

import com.company.entity.Address;
import com.company.entity.User;

public interface UserStorage {
    boolean save(User user);

    String updateName(int id, String name);

    String updatePassword(int id, String password);

    Address updateAddress(int id, Address address);

    void delete(int id);

    void delete(User user);

    User[] getAll();

    User[] getAllByName(String name);

    User getById(int id);

    User getByLogin(String login);

    User getByAddress(Address address);

    boolean contains(Address address);

    boolean contains(User user);

    boolean contains(int id);

    boolean contains(String login);
}
