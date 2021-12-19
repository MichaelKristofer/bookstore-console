package com.company.console.action;

public interface AddressAction {
    void save();

    void updateStreet();

    void updateHome();

    void delete();

    void deleteById();

    void getAllByStreet();

    void getAllByHome();

    void getById();

    void getAll();
}
