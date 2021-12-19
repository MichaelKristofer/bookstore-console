package com.company.console.action;

import com.company.console.Basket;
import com.company.console.ConsoleApplication;
import com.company.console.Session;
import com.company.console.util.ConsoleReader;
import com.company.console.util.ConsoleWriter;
import com.company.entity.Address;
import com.company.entity.User;
import com.company.service.AddressService;
import com.company.service.AddressServiceImpl;
import com.company.service.UsersService;
import com.company.service.UsersServiceImpl;

public class ConsoleUserAction implements UserAction {

    private UsersService usersService = new UsersServiceImpl();
    private AddressService addressService = new AddressServiceImpl();

    @Override
    public void logout() {
        ConsoleApplication.session = null;
    }

    @Override
    public void save() {
        ConsoleWriter.write("Enter name");
        String name = ConsoleReader.readString();
        ConsoleWriter.write("Enter login");
        String login = ConsoleReader.readString();
        ConsoleWriter.write("Enter password");
        String password = ConsoleReader.readString();
        ConsoleWriter.write("Enter street");
        String street = ConsoleReader.readString();
        ConsoleWriter.write("Enter home");
        int home = ConsoleReader.readInt();
        Address address = new Address(street, home);
        User user = new User(name, login, password, address, "USER");
        boolean save = usersService.save(user);
        if (save) {
            ConsoleWriter.write("Done");
        } else {
            ConsoleWriter.write("This user is exist!");
        }
    }

    @Override
    public void authorization() {
        ConsoleWriter.write("Enter login");
        String login = ConsoleReader.readString();
        ConsoleWriter.write("Enter password");
        String password = ConsoleReader.readString();
        User byLogin = usersService.getByLogin(login);
        if (byLogin.getPassword().equals(password)){
            ConsoleApplication.session = new Session(byLogin, new Basket());
        }
    }

    @Override
    public void updateName() {
        User[] all = usersService.getAll();
        ConsoleWriter.write("Choose user");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " user " + all[i]);
        }
        int i = ConsoleReader.readInt() - 1;
        User byId = all[i];
        ConsoleWriter.write("Enter new name");
        String name = ConsoleReader.readString();
        String name1 = usersService.updateName(byId.getId(), name);
        ConsoleWriter.write(name1 + " was changed " + name);

    }

    @Override
    public void updateNameForUser() {
        int id = ConsoleApplication.session.getUser().getId();
        ConsoleWriter.write("Enter new name");
        String name = ConsoleReader.readString();
        String s = usersService.updateName(id, name);
        ConsoleWriter.write("Last name: " + s + " new name: " + name);
    }

    @Override
    public void updatePassword() {
        User[] all = usersService.getAll();
        ConsoleWriter.write("Choose user");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " user " + all[i]);
        }
        int i = ConsoleReader.readInt() - 1;
        User byId = all[i];
        ConsoleWriter.write("Enter new password");
        String pass = ConsoleReader.readString();
        String pass1 = usersService.updatePassword(byId.getId(), pass);
        ConsoleWriter.write(pass1 + " was changed " + pass);
    }

    @Override
    public void updatePasswordForUser() {
        int id = ConsoleApplication.session.getUser().getId();
        ConsoleWriter.write("Enter new password");
        String pass = ConsoleReader.readString();
        String s = usersService.updatePassword(id, pass);
        ConsoleWriter.write("Last pass: " + s + " new pass: " + pass);
    }

    @Override
    public void updateAddress() {
        User[] all = usersService.getAll();
        ConsoleWriter.write("Choose user");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " user " + all[i]);
        }
        int i = ConsoleReader.readInt() - 1;
        User byId = all[i];
        ConsoleWriter.write("Enter new street");
        String street = ConsoleReader.readString();
        ConsoleWriter.write("Enter new home");
        int home = ConsoleReader.readInt();
        Address address1 = usersService.updateAddress(byId.getId(), new Address(street, home));
        ConsoleWriter.write(address1 + " was changed " + address1.getStreet() + address1.getHome());
    }

    @Override
    public void updateAddressForUser() {
        int id = ConsoleApplication.session.getUser().getId();
        ConsoleWriter.write("Enter new street");
        String street = ConsoleReader.readString();
        ConsoleWriter.write("Enter new home");
        int home = ConsoleReader.readInt();
        Address address = new Address(street, home);
        usersService.updateAddress(id, address);
    }

    @Override
    public void deleteById() {
        ConsoleWriter.write("Enter Id");
        int id = ConsoleReader.readInt();
        usersService.delete(id);
    }

    @Override
    public void delete() {
        User[] all = usersService.getAll();
        ConsoleWriter.write("Choose user");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Name " + all[i].getName() + " login " + all[i].getLogin());
        }
        int i = ConsoleReader.readInt() - 1;
        usersService.delete(all[i]);
    }

    @Override
    public void getAll() {
        User[] all = usersService.getAll();
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " id " + all[i].getId() + " Login " + all[i].getLogin() + " name " + all[i].getName() + " pass " + all[i].getPassword() + " address " + all[i].getAddress());
        }
    }

    @Override
    public void getAllByName() {
        User[] all = usersService.getAll();
        ConsoleWriter.write("Choose name");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + all[i].getName());
        }
        int s = ConsoleReader.readInt() - 1;
        User user = usersService.getById(s);
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write(" id " + user.getId() + " Login " + user.getLogin() + " name " + user.getName() + " pass " + user.getPassword() + " address " + user.getAddress());
        }
    }

    @Override
    public void getById() {
        ConsoleWriter.write("Enter id");
        int id = ConsoleReader.readInt();
        usersService.getById(id);
    }

    @Override
    public void getByLogin() {
        ConsoleWriter.write("Choose login");
        String login = ConsoleReader.readString();
        usersService.getByLogin(login);
    }

    @Override
    public void getByAddress() {
        Address[] all = addressService.getAll();
        ConsoleWriter.write("Choose address");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Address: home " + all[i].getHome() + " street " + all[i].getStreet());
        }
        int i = ConsoleReader.readInt() - 1;
        Address address = all[i];
        User byAddress = usersService.getByAddress(address);
        ConsoleWriter.write("Address: " + byAddress);
    }
}
