package com.company.console.action;

import com.company.entity.Author;
import com.company.entity.Book;

public interface BookAction {
    void save();

    void delete();

    void updateTitle();

    void updateDescription();

    void updatePrice();

    void updateAuthor();

    void getById();

    void getByTitle();

    void getAll();

    void getAllByAuthor();

    void getAllByPrice();
}
