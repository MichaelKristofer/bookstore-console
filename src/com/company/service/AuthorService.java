package com.company.service;

import com.company.entity.Author;

public interface AuthorService {
    boolean save(Author author);

    String updateName(int id, String name);

    String updateDescription(int id, String description);

    void delete(int id);

    void delete(Author author);

    Author getById(int id);

    Author[] getAll();

    Author getByName(String name);
}
