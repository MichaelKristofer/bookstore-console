package com.company.console.action;

public interface UserAction {

    void save();

    void authorization();

    void logout();

    void updateName();

    void updateNameForUser();

    void updatePassword();

    void updatePasswordForUser();

    void updateAddress();

    void updateAddressForUser();

    void deleteById();

    void delete();

    void getAll();

    void getAllByName();

    void getById();

    void getByLogin();

    void getByAddress();
}
