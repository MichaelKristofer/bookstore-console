package com.company.service;

import com.company.entity.Address;
import com.company.entity.Store;
import com.company.storage.InMemoryStoreStorage;
import com.company.storage.StoreStorage;

public class StoreServiceImpl implements StoreService {
    private StoreStorage serviceStorage = new InMemoryStoreStorage();
    @Override
    public boolean save(Store store) {
        if (serviceStorage.contains(store.getTitle()) && serviceStorage.contains(store.getAddress())) {
            return false;
        } else {
            serviceStorage.save(store);
            return true;
        }
    }

    @Override
    public Address updateAddressById(int id, Address address) {
        if (serviceStorage.contains(id)) {
            return serviceStorage.updateAddressById(id, address);
        }
        return null;
    }

    @Override
    public String updateTitleById(int id, String title) {
        if (serviceStorage.contains(id)){
            return serviceStorage.updateTitleById(id, title);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        if (serviceStorage.contains(id)) {
            serviceStorage.delete(getById(id));
        }

    }

    @Override
    public void delete(Store store) {
        if (serviceStorage.contains(store.getId())){
            serviceStorage.delete(store);
        }

    }

    @Override
    public Store[] getAll() {
        return serviceStorage.getAll();
    }

    @Override
    public Store getByTitle(String title) {
        if (serviceStorage.contains(title)) {
            return serviceStorage.getByTitle(title);
        }
        return null;
    }

    @Override
    public Store getById(int id) {
        if (serviceStorage.contains(id)) {
            return serviceStorage.getById(id);
        }
        return null;
    }

    @Override
    public Store getByAddress(Address address) {
        if (serviceStorage.contains(address)) {
            return serviceStorage.getByAddress(address);
        }
        return null;
    }
}
