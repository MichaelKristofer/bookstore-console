package com.company.storage;

import com.company.entity.Address;
import com.company.entity.Store;

public interface StoreStorage {
    void save(Store store);

    Address updateAddressById(int id, Address address);

    String updateTitleById(int id, String title);

    void delete(int id);

    void delete(Store store);

    Store[] getAll();

    Store getByTitle(String title);

    Store getById(int id);

    Store getByAddress(Address address);

    boolean contains(Address address);

    boolean contains(String title);

    boolean contains(int id);
}
