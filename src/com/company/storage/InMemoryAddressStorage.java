package com.company.storage;

import com.company.entity.Address;

public class InMemoryAddressStorage implements AddressStorage {
    private static Address[] addresses = new Address[10];
    private int size;
    private static int incId = 1;

    @Override
    public void save(Address address) {
        address.setId(incId++);
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) {
                addresses[i] = address;
                size++;
                break;
            }
        }
    }

    @Override
    public String updateStreet(int id, String street) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getId() == id) {
                String addresses1 = addresses[i].getStreet();
                addresses[i].setStreet(street);
                return addresses1;
            }
        }
        return null;
    }

    @Override
    public Integer updateHome(int id, int home) {
        for (int i = 0; i < size; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getId() == id) {
                int addresses1 = addresses[i].getHome();
                addresses[i].setHome(home);
                return addresses1;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    addresses[j] = addresses[i + 1];
                }
                size--;
                break;
            }
        }
    }

    @Override
    public void delete(Address address) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i] == address) {
                for (int j = i; j < addresses.length - 1; j++) {
                    addresses[j] = addresses[i + 1];
                }
                size--;
                break;
            }
        }
    }

    @Override
    public Address[] getAllByStreet(String street) {
        int g = 0;
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getStreet().equals(street)) {
                g++;
            }
        }
        Address[] arr = new Address[g];
        for (int i = 0, j = 0;i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getStreet().equals(street)) {
                arr[j++] = addresses[i];
            }
        }
        return arr;
    }

    @Override
    public Address[] getAllByHome(int home) {
        int g = 0;
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getHome() == home) {
                g++;
            }
        }
        Address[] arr = new Address[g];
        for (int i = 0, j = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getHome() == home) {
                arr[j++] = addresses[i];
            }
        }
        return arr;
    }

    @Override
    public Address getById(int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getId() == id) {
                return addresses[i];
            }
        }
        return null;
    }

    @Override
    public Address[] getAll() {
        Address[] arr = new Address[size];
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            arr[i] = addresses[i];
        }
        return arr;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Address address) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].equals(address)) {
                return true;
            }
        }
        return false;
    }
}
