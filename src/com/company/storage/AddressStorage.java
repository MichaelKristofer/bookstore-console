package com.company.storage;

import com.company.entity.Address;

public interface AddressStorage {

    void save(Address address);

    String updateStreet(int id, String street);

    Integer updateHome(int id, int home);

    void delete(int id);

    void delete(Address address);

    Address[] getAllByStreet(String street);

    Address[] getAllByHome(int home);

    Address getById(int id);

    Address[] getAll();

    boolean contains(int id);

    boolean contains(Address address);
}
