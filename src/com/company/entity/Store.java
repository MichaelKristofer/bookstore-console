package com.company.entity;

public class Store {
    private int id;
    private String title;
    private Address address;

    public Store() {
    }

    public Store(String title, Address address) {
        this.title = title;
        this.address = address;
    }

    public Store(int id, String title, Address address) {
        this.id = id;
        this.title = title;
        this.address = address;
    }

    public Store(int size) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address=" + address +
                '}';
    }
}
