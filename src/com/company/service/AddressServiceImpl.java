package com.company.service;

import com.company.entity.Address;
import com.company.storage.AddressStorage;
import com.company.storage.InMemoryAddressStorage;

public class AddressServiceImpl implements AddressService{
    private AddressStorage addressStorage = new InMemoryAddressStorage();

    @Override
    public boolean save(Address address) {
        if (addressStorage.contains(address)) {
            return false;
        }
        else {
            addressStorage.save(address);
            return true;
        }
    }

    @Override
    public String updateStreet(int id, String street) {
        if (addressStorage.contains(id)) {
            return addressStorage.updateStreet(id, street);
        }
        return null;
    }

    @Override
    public Integer updateHome(int id, int home) {
        if (addressStorage.contains(id)) {
            return addressStorage.updateHome(id, home);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        if (addressStorage.contains(id)) {
            addressStorage.delete(id);
        }

    }

    @Override
    public void delete(Address address) {
        if (addressStorage.contains(address)) {
            addressStorage.delete(address);
        }
    }

    @Override
    public Address[] getAllByStreet(String street) {
        return addressStorage.getAllByStreet(street);
    }

    @Override
    public Address[] getAllByHome(int home) {
        return addressStorage.getAllByHome(home);
    }

    @Override
    public Address getById(int id) {
        if (addressStorage.contains(id)){
            return addressStorage.getById(id);
        }
        return null;
    }

    @Override
    public Address[] getAll() {
        return addressStorage.getAll();
    }
}

