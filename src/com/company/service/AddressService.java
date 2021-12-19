package com.company.service;

import com.company.entity.Address;

public interface AddressService {

    boolean save(Address address);

    String updateStreet(int id, String street);

    Integer updateHome(int id, int home);

    void delete(int id);

    void delete(Address address);

    Address[] getAllByStreet(String street);

    Address[] getAllByHome(int home);

    Address getById(int id);

    Address[] getAll();
}
