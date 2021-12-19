package com.company.console.action;

import com.company.console.util.ConsoleReader;
import com.company.console.util.ConsoleWriter;
import com.company.entity.Address;
import com.company.service.AddressService;
import com.company.service.AddressServiceImpl;

public class ConsoleAddressAction implements AddressAction {

    private AddressService addressService = new AddressServiceImpl();

    @Override
    public void save() {
        ConsoleWriter.write("Enter street");
        String street = ConsoleReader.readString();
        ConsoleWriter.write("Enter home number");
        int home = ConsoleReader.readInt();
        Address address = new Address(street, home);
        boolean save = addressService.save(address);
        if (save) {
            ConsoleWriter.write("Done");
        } else {
            ConsoleWriter.write("This address is exist!");
        }
    }

    @Override
    public void updateStreet() {
        Address[] all = addressService.getAll();
        ConsoleWriter.write("Choose address");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Address " + all[i].getStreet());
        }
        int i = ConsoleReader.readInt() - 1;
        ConsoleWriter.write("Enter new street");
        String s = ConsoleReader.readString();
        String s1 = addressService.updateStreet(all[i].getId(), s);
        ConsoleWriter.write(s1 + " was changed to " + s);
    }

    @Override
    public void updateHome() {
        Address[] all = addressService.getAll();
        ConsoleWriter.write("Choose home number");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Home " + all[i].getHome());
        }
        int i = ConsoleReader.readInt() - 1;
        ConsoleWriter.write("Enter new home number");
        int s = ConsoleReader.readInt();
        int s1 = addressService.updateHome(all[i].getId(), s);
        ConsoleWriter.write(s1 + " was changed to " + s);
    }

    @Override
    public void delete() {
        Address[] all = addressService.getAll();
        ConsoleWriter.write("Choose address");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Address " + all[i].getStreet() + " home: " + all[i].getHome());
        }
        int i = ConsoleReader.readInt() - 1;
        addressService.delete(all[i]);
    }

    @Override
    public void deleteById() {
        ConsoleWriter.write("Enter id address");
        int id = ConsoleReader.readInt();
        addressService.delete(id);
    }

    @Override
    public void getAllByStreet() {
        ConsoleWriter.write("Enter street");
        String street = ConsoleReader.readString();
        Address[] allByStreet = addressService.getAllByStreet(street);
        for (int i = 0; i < allByStreet.length; i++) {
            ConsoleWriter.write((i + 1) + " Address " + allByStreet[i].getStreet() + " home: " + allByStreet[i].getHome());
        }
    }

    @Override
    public void getAllByHome() {
        ConsoleWriter.write("Enter home");
        int home = ConsoleReader.readInt();
        Address[] allByHome = addressService.getAllByHome(home);
        for (int i = 0; i < allByHome.length; i++) {
            ConsoleWriter.write((i + 1) + " Home " + allByHome[i].getHome() + " address " + allByHome[i].getStreet());
        }
    }

    @Override
    public void getById() {
        ConsoleWriter.write("Enter Id");
        int id = ConsoleReader.readInt();
        Address byId = addressService.getById(id);
        ConsoleWriter.write("Street " + byId.getStreet() + " home " + byId.getHome());
    }

    @Override
    public void getAll() {
        Address[] all = addressService.getAll();
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + "Address " + all[i].getStreet() + " home " + all[i].getHome());
        }
    }
}
