package com.company.storage;

import com.company.entity.Author;

public class InMemoryAuthorStorage implements AuthorStorage {
    private static Author[] authors = new Author[10];
    private int size;
    private static int incId = 1;

    @Override
    public void save(Author author) {
        author.setId(incId++);
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null){
                authors[i] = author;
                size++;
                break;
            }
        }
    }

    @Override
    public String updateName(int id, String name) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].getId() == id) {
                String name1 = authors[i].getName();
                authors[i].setName(name);
                return name1;
            }
        }
        return name;
    }

    @Override
    public String updateDescription(int id, String description) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].getId() == id) {
                String description1 = authors[i].getDescription();
                authors[i].setDescription(description);
                return description1;
            }
        }
        return description;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].getId() == id) {
                for (int j = i; j < authors.length - 1; j++) {
                    authors[j] = authors[j + 1];
                }
                break;
            }
        }
    }

    @Override
    public void delete(Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].equals(author)) {
                for (int j = i; j < authors.length - 1; j++) {
                    authors[j] = authors[j + 1];
                }
                break;
            }
        }
    }

    @Override
    public Author getById(int id) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].getId() == id) {
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public Author[] getAll() {
        Author[] arr = new Author[authors.length];
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            arr[i] = authors[i];
        }
        return arr;
    }

    @Override
    public Author getByName(String name) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].getName().equals(name)) {
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public boolean contains(String name) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].equals(author)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
}
