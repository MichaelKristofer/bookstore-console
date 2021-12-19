package com.company.service;

import com.company.entity.Author;
import com.company.storage.AuthorStorage;
import com.company.storage.InMemoryAuthorStorage;

public class AuthorServiceImpl implements AuthorService {
    private AuthorStorage authorStorage = new InMemoryAuthorStorage();

    @Override
    public boolean save(Author author) {
        if (authorStorage.contains(author)) {
            return false;
        } else {
            authorStorage.save(author);
            return true;
        }

    }

    @Override
    public String updateName(int id, String name) {
        if (authorStorage.contains(id)) {
            return authorStorage.updateName(id, name);
        }
        return null;
    }

    @Override
    public String updateDescription(int id, String description) {
        if (authorStorage.contains(id)) {
            return authorStorage.updateDescription(id, description);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        if (authorStorage.contains(id)) {
            authorStorage.delete(id);
        }
    }

    @Override
    public void delete(Author author) {
        if (authorStorage.contains(author)){
            authorStorage.delete(author);
        }
    }

    @Override
    public Author getById(int id) {
        if (authorStorage.contains(id)) {
            return authorStorage.getById(id);
        }
        return null;
    }

    @Override
    public Author[] getAll() {
        return authorStorage.getAll();
    }

    @Override
    public Author getByName(String name) {
        if (authorStorage.contains(name)) {
            return authorStorage.getByName(name);
        }
        return null;
    }
}
