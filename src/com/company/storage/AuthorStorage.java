package com.company.storage;

import com.company.entity.Author;

public interface AuthorStorage {
    void save(Author author);

    String updateName(int id, String name);

    String updateDescription(int id, String description);

    void delete(int id);

    void delete(Author author);

    Author getById(int id);

    Author[] getAll();

    Author getByName(String name);

    boolean contains(String name);

    boolean contains(Author author);

    boolean contains(int id);
}
