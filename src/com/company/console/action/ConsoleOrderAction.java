package com.company.console.action;

import com.company.console.ConsoleApplication;
import com.company.console.util.ConsoleReader;
import com.company.console.util.ConsoleWriter;
import com.company.entity.*;
import com.company.service.*;

import java.io.Console;
import java.util.Arrays;

public class ConsoleOrderAction implements OrderAction {

    private OrderService orderService = new OrderServiceImpl();
    private StoreService storeService = new StoreServiceImpl();
    private BookService bookService = new BookServiceImpl();
    private UsersService usersService = new UsersServiceImpl();
    private AddressService addressService = new AddressServiceImpl();

    @Override
    public void save() {
        ConsoleWriter.write("1 - Delivery, 2 - Pickup");
        User user = ConsoleApplication.session.getUser();
        Book[] books = ConsoleApplication.session.getBasket().getBooks();
        switch (ConsoleReader.readInt()) {
            case 1:
                ConsoleWriter.write("Enter street");
                String street = ConsoleReader.readString();
                ConsoleWriter.write("Enter home");
                int home = ConsoleReader.readInt();
                Address address = new Address(street, home);
                Order order = new Order(user, address, null, books);
                orderService.save(order);
                break;
            case 2:
                ConsoleWriter.write("Choose store address");
                Store[] all = storeService.getAll();
                for (int i = 0; i < all.length; i++) {
                    ConsoleWriter.write((i + 1) + " address " + all[i].getAddress());
                }
                int i = ConsoleReader.readInt() - 1;
                Order order1 = new Order(user, null, all[i],books);
                orderService.save(order1);
                break;
        }
    }

    @Override
    public void updateUser() {
        Order[] all = orderService.getAll();
        ConsoleWriter.write("Choose new user");
        for (int i1 = 0; i1 < all.length; i1++) {
            ConsoleWriter.write((i1 + 1) + " User " + all[i1].getUser());
        }
        int i1 = ConsoleReader.readInt() - 1;
        Order order = all[i1];
        User user1 = orderService.updateUser(order.getId(), order.getUser());
        ConsoleWriter.write(user1.getName() + " was changed " + order);
    }

    @Override
    public void updateAddress() {
        Order[] all = orderService.getAll();
        ConsoleWriter.write("Choose new address");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " address " + all[i].getAddress());
        }
        int i = ConsoleReader.readInt() - 1;
        Order order = all[i];
        Address address1 = orderService.updateAddress(order.getId(), order.getAddress());
        ConsoleWriter.write(address1 + " was changed " + order);

    }

    @Override
    public void updateStore() {
        Order[] all = orderService.getAll();
        ConsoleWriter.write("Choose new store");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " store " + all[i].getStore());
        }
        int i = ConsoleReader.readInt() - 1;
        Order order = all[i];
        Store store = orderService.updateStore(order.getId(), order.getStore());
        ConsoleWriter.write(store + " was changed " + order);
    }

    @Override
    public void addBook() {
        Order[] allOrders = orderService.getAll();
        Book[] allBooks = bookService.getAll();
        ConsoleWriter.write("Choose order");
        for (int i = 0; i < allOrders.length; i++) {
            ConsoleWriter.write((i + 1) + allOrders[i].getUser().getLogin());
        }
        int i = ConsoleReader.readInt() - 1;
        ConsoleWriter.write("Choose book");
        for (int i1 = 0; i < allBooks.length; i++) {
            ConsoleWriter.write((i + 1) + " Title " + allBooks[i1].getTitle() + " author " + allBooks[i1].getAuthor());
        }
        int i1 = ConsoleReader.readInt() - 1;
        orderService.addBook(allOrders[i].getId(), allBooks[i1]);

    }

    @Override
    public void deleteBook() {
        Order[] allOrders = orderService.getAll();
        Book[] allBooks = bookService.getAll();
        ConsoleWriter.write("Choose order");
        for (int i = 0; i < allOrders.length; i++) {
            ConsoleWriter.write((i + 1) + allOrders[i].getUser().getLogin());
        }
        int i = ConsoleReader.readInt() - 1;
        ConsoleWriter.write("Choose book");
        for (int i1 = 0; i < allBooks.length; i++) {
            ConsoleWriter.write((i1 + 1) + " Title " + allBooks[i1].getTitle() + " author " + allBooks[i1].getAuthor());
        }
        int i1 = ConsoleReader.readInt() - 1;
        orderService.deleteBook(allOrders[i].getId(), allBooks[i1].getId());
    }

    @Override
    public void deleteId() {
        Order[] all = orderService.getAll();
        ConsoleWriter.write("Enter id");
        int id = ConsoleReader.readInt();
        orderService.delete(id);
    }

    @Override
    public void delete() {
        Order[] all = orderService.getAll();
        ConsoleWriter.write("Choose order");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " order " + all[i]);
        }
        int i = ConsoleReader.readInt() - 1;
        orderService.delete(all[i]);
    }

    @Override
    public void getAllBooks() {
        Order[] all = orderService.getAll();
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Book " + Arrays.toString(all[i].getBooks()));
        }
    }

    @Override
    public void getAll() {
        Order[] all = orderService.getAll();
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " order " + all[i]);
        }
    }

    @Override
    public void getAllByUser() {
        User[] allUser = usersService.getAll();
        Order[] allOrders = orderService.getAll();
        ConsoleWriter.write("Choose user");
        for (int i = 0; i < allUser.length; i++) {
            ConsoleWriter.write((i + 1) + " user name " + allUser[i].getName() + " login " + allUser[i].getLogin());
        }
        int i = ConsoleReader.readInt() - 1;
        User user = allUser[i];
        Order[] userOrders = new Order[allOrders.length];
        for (int f = 0, i1 = 0; f < allOrders.length; f++) {
            if (allOrders[f].getUser().equals(user)) {
                userOrders[i1++] = allOrders[f];
            }
        }
        for (int i1 = 0; i1 < userOrders.length; i1++) {
            ConsoleWriter.write(" order " + userOrders[i1]);
        }
    }

    @Override
    public void getAllByUserForUser() {
        Order[] allOrders = orderService.getAll();
        User user = ConsoleApplication.session.getUser();
        Order[] userOrders = new Order[allOrders.length];
        for (int f = 0, i1 = 0; f < allOrders.length; f++) {
            if (allOrders[f].getUser().equals(user)) {
                userOrders[i1++] = allOrders[f];
            }
        }
        for (int i1 = 0; i1 < userOrders.length; i1++) {
            ConsoleWriter.write(" order " + userOrders[i1]);
        }
    }

    @Override
    public void getAllByAddress() {
        ConsoleWriter.write("Enter street");
        String street = ConsoleReader.readString();
        ConsoleWriter.write("Enter home");
        int home = ConsoleReader.readInt();
        Address address = new Address(street, home);
        orderService.getAllByAddress(address);
    }

    @Override
    public void getAllByStore() {
        Store[] allStore = storeService.getAll();
        ConsoleWriter.write("Choose store");
        for (int i = 0; i < allStore.length; i++) {
            ConsoleWriter.write((i + 1) + allStore[i].getTitle());
        }
        int i = ConsoleReader.readInt();
        Store store = allStore[i];
        orderService.getAllByStore(store);
    }

    @Override
    public void getById() {
        Order[] all = orderService.getAll();
        ConsoleWriter.write("Enter id");
        int id = ConsoleReader.readInt();
        orderService.getById(id);
    }
}
