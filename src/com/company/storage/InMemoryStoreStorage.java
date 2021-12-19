package com.company.storage;

import com.company.entity.Address;
import com.company.entity.Store;

public class InMemoryStoreStorage implements StoreStorage {
    private Store[] stores = new Store[10];
    private int size;
    private static int incId = 1;

    @Override
    public void save(Store store) {
        store.setId(incId++);
        for (int i = 0; i < stores.length; i++) {
            if (stores[i] == null) {
                stores[i] = store;
                size++;
                break;
            }
        }
    }

    @Override
    public Address updateAddressById(int id, Address address) {
        for (int i = 0; i < size; i++) {
            if(stores[i] == null) break;
            if (stores[i].getId() == id) {
                Address address1 = stores[i].getAddress();
                stores[i].setAddress(address);
                return address1;
            }
        }
        return address;
    }

    @Override
    public String updateTitleById(int id, String title) {
        for (int i = 0; i < size; i++) {
            if(stores[i] == null) break;
            if (stores[i].getId() == id) {
                String title1 = stores[i].getTitle();
                stores[i].setTitle(title);
                return title1;
            }
        }
        return title;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < size; i++) {
            if(stores[i] == null) break;
            if(stores[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    stores[i] = stores[i + 1];
                }
                size--;
                break;
            }
        }
    }

    @Override
    public void delete(Store store) {
        for (int i = 0; i < size; i++) {
            if(stores[i] == null) break;
            if(stores[i].equals(store)){
                for (int j = i; j < size; j++) {
                    stores[j] = stores[i + 1];
                }
                size--;
                break;
            }
        }
    }

    @Override
    public Store[] getAll() {
        Store[] arr = new Store[size];
        for (int i = 0; i < size; i++) {
            if(stores[i] == null) break;
            stores[i] = arr[i];
        }
        return arr;
    }

    @Override
    public Store getByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if(stores[i] == null) break;
            if (stores[i].getTitle().equals(title)) {
                return stores[i];
            }
        }
        return null;
    }

    @Override
    public Store getById(int id) {
        for (int i = 0; i < size; i++) {
            if(stores[i] == null) break;
            if (stores[i].getId() == id) {
                return stores[i];
            }
        }
        return null;
    }

    @Override
    public Store getByAddress(Address address) {
        for (int i = 0; i < size; i++) {
            if(stores[i] == null) break;
            if (stores[i].getAddress().equals(address)) {
                return stores[i];
            }
        }
        return null;
    }

    @Override
    public boolean contains(Address address) {
        for (int i = 0; i < size; i++) {
            if(stores[i] == null) break;
            if (stores[i].getAddress().equals(address)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String title) {
        for (int i = 0; i < size; i++) {
            if(stores[i] == null) break;
            if (stores[i].getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < size; i++) {
            if(stores[i] == null) break;
            if(stores[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
}
