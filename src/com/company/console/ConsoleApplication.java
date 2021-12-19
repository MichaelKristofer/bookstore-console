package com.company.console;

import com.company.console.action.*;
import com.company.console.util.ConsoleReader;
import com.company.console.util.ConsoleWriter;

public class ConsoleApplication {

    public static Session session;

    private UserAction userAction = new ConsoleUserAction();
    private BookAction bookAction = new ConsoleBookAction();
    private OrderAction orderAction = new ConsoleOrderAction();
    private AddressAction addressAction = new ConsoleAddressAction();
    private AuthorAction authorAction = new ConsoleAuthorAction();

    public void run() {
        while (true) {
            if (session == null) {
                guestMenu();
                switch (ConsoleReader.readInt()) {
                    case 0:
                        return;
                    case 1:
                        userAction.save();
                        break;
                    case 2:
                        userAction.authorization();
                        break;
                }
            } else if (session.getUser().getRole().equals("USER")){
                userMenu();
                switch (ConsoleReader.readInt()){
                    case 0:
                        userAction.logout();
                        break;
                    case 1:
                        bookAction.getAllByAuthor();
                        break;
                    case 2:
                        bookAction.getAll();
                        break;
                    case 3:
                        bookAction.getAllByPrice();
                        break;
                    case 4:
                        basketMenu();
                        switch (ConsoleReader.readInt()){
                            case 0:
                                break;
                            case 1:
                                orderAction.save();
                                break;
                        }
                        break;
                    case 5:
                        profileMenu();
                        switch (ConsoleReader.readInt()){
                            case 0:
                                break;
                            case 1:
                                userAction.updateAddressForUser();
                                break;
                            case 2:
                                userAction.updateNameForUser();
                                break;
                            case 3:
                                userAction.updatePasswordForUser();
                                break;
                        }
                        break;
                    case 6:
                        ordersForUserMenu();
                        switch(ConsoleReader.readInt()) {
                            case 0:
                                break;
                            case 1:
                                orderAction.updateAddress();
                                break;
                            case 2:
                                orderAction.updateStore();
                                break;
                            case 3:
                                orderAction.addBook();
                                break;
                            case 4:
                                orderAction.deleteBook();
                                break;
                            case 5:
                                orderAction.getAllBooks();
                                break;
                            case 6:
                                orderAction.getAllByUserForUser();
                                break;
                        }
                        break;

                }
            } else {
                adminMenu();
                switch (ConsoleReader.readInt()){
                    case 0:
                        userAction.logout();
                        break;
                    case 1:
                        bookMenu();
                        switch (ConsoleReader.readInt()){
                            case 0:
                                break;
                            case 1:
                                bookAction.save();
                                break;
                            case 2:
                                bookAction.delete();
                                break;
                            case 3:
                                bookAction.updateTitle();
                                break;
                            case 4:
                                bookAction.updateDescription();
                                break;
                            case 5:
                                bookAction.updatePrice();
                                break;
                            case 6:
                                bookAction.updateAuthor();
                                break;
                            case 7:
                                bookAction.getById();
                                break;
                            case 8:
                                bookAction.getByTitle();
                                break;
                            case 9:
                                bookAction.getAll();
                                break;
                            case 10:
                                bookAction.getAllByAuthor();
                                break;
                            case 11:
                                bookAction.getAllByPrice();
                                break;
                        }
                        break;
                    case 2:
                        ordersForAdminMenu();
                        switch(ConsoleReader.readInt()) {
                            case 0:
                                break;
                            case 1:
                                orderAction.save();
                                break;
                            case 2:
                                orderAction.updateUser();
                                break;
                            case 3:
                                orderAction.updateAddress();
                                break;
                            case 4:
                                orderAction.updateStore();
                                break;
                            case 5:
                                orderAction.addBook();
                                break;
                            case 6:
                                orderAction.deleteBook();
                                break;
                            case 7:
                                orderAction.deleteId();
                                break;
                            case 8:
                                orderAction.delete();
                                break;
                            case 9:
                                orderAction.getAllBooks();
                                break;
                            case 10:
                                orderAction.getAll();
                                break;
                            case 11:
                                orderAction.getAllByUser();
                                break;
                            case 12:
                                orderAction.getAllByAddress();
                                break;
                            case 13:
                                orderAction.getAllByStore();
                                break;
                            case 14:
                                orderAction.getById();
                                break;
                        }
                        break;
                    case 3:
                        addressMenu();
                        switch (ConsoleReader.readInt()) {
                            case 0:
                                break;
                            case 1:
                                addressAction.save();
                                break;
                            case 2:
                                addressAction.updateStreet();
                                break;
                            case 3:
                                addressAction.updateHome();
                                break;
                            case 4:
                                addressAction.delete();
                                break;
                            case 5:
                                addressAction.deleteById();
                                break;
                            case 6:
                                addressAction.getAllByStreet();
                                break;
                            case 7:
                                addressAction.getAllByHome();
                                break;
                            case 8:
                                addressAction.getById();
                                break;
                            case 9:
                                addressAction.getAll();
                                break;
                        }
                        break;
                    case 4:
                        authorMenu();
                        switch (ConsoleReader.readInt()) {
                            case 0:
                                break;
                            case 1:
                                authorAction.save();
                                break;
                            case 2:
                                authorAction.updateName();
                                break;
                            case 3:
                                authorAction.updateDescription();
                                break;
                            case 4:
                                authorAction.delete();
                                break;
                            case 5:
                                authorAction.deleteById();
                                break;
                            case 6:
                                authorAction.getById();
                                break;
                            case 7:
                                authorAction.getAll();
                                break;
                            case 8:
                                authorAction.getByName();
                                break;
                        }
                        break;
                    case 5:
                        userMenuForAdmin();
                        switch (ConsoleReader.readInt()) {
                            case 0:
                                break;
                            case 1:
                                userAction.save();
                                break;
                            case 2:
                                userAction.updateName();
                                break;
                            case 3:
                                userAction.updatePassword();
                                break;
                            case 4:
                                userAction.updateAddress();
                                break;
                            case 5:
                                userAction.deleteById();
                                break;
                            case 6:
                                userAction.delete();
                                break;
                            case 7:
                                userAction.getAll();
                                break;
                            case 8:
                                userAction.getAllByName();
                                break;
                            case 9:
                                userAction.getById();
                                break;
                            case 10:
                                userAction.getByLogin();
                                break;
                            case 11:
                                userAction.getByAddress();
                                break;
                        }
                        break;

                }
            }
        }
    }

    private void guestMenu() {
        ConsoleWriter.write("0 - Exit");
        ConsoleWriter.write("1 - Registration");
        ConsoleWriter.write("2 - Authorization");
    }

    private void basketMenu(){
        ConsoleWriter.write("0 - Exit");
        ConsoleWriter.write("1 - Create New Order");
    }

    private void profileMenu(){
        ConsoleWriter.write("0 - Exit");
        ConsoleWriter.write("1 - Change Address");
        ConsoleWriter.write("2 - Change Name");
        ConsoleWriter.write("2 - Change Password");
    }

    private void ordersForUserMenu(){
        ConsoleWriter.write("0 - Exit");
        ConsoleWriter.write("1 - Change Address");
        ConsoleWriter.write("2 - Change Store");
        ConsoleWriter.write("3 - Add Book");
        ConsoleWriter.write("4 - Delete Book");
        ConsoleWriter.write("5 - Get All Books");
        ConsoleWriter.write("6 - Get All Orders");
    }

    private void userMenuForAdmin(){
        ConsoleWriter.write("0 - Back");
        ConsoleWriter.write("1 - Save");
        ConsoleWriter.write("2 - Update Name");
        ConsoleWriter.write("3 - Update Password");
        ConsoleWriter.write("4 - Update Address");
        ConsoleWriter.write("5 - Delete By Id");
        ConsoleWriter.write("6 - Delete");
        ConsoleWriter.write("7 - Get All");
        ConsoleWriter.write("8 - Get All By Name");
        ConsoleWriter.write("9 - Get By Id");
        ConsoleWriter.write("10 - Get By Login");
        ConsoleWriter.write("11 - Get By Address");
    }

    private void authorMenu() {
        ConsoleWriter.write("0 - Back");
        ConsoleWriter.write("1 - Save");
        ConsoleWriter.write("2 - Update Name");
        ConsoleWriter.write("3 - Update Description");
        ConsoleWriter.write("4 - Delete");
        ConsoleWriter.write("5 - Delete By Id");
        ConsoleWriter.write("6 - Get By Id");
        ConsoleWriter.write("7 - Get All");
        ConsoleWriter.write("8 - Get By Name");
    }

    private void ordersForAdminMenu(){
        ConsoleWriter.write("0 - Back");
        ConsoleWriter.write("1 - Save");
        ConsoleWriter.write("2 - Update User");
        ConsoleWriter.write("3 - Update Address");
        ConsoleWriter.write("4 - Update Store");
        ConsoleWriter.write("5 - Add Book");
        ConsoleWriter.write("6 - Delete Book");
        ConsoleWriter.write("7 - Delete By Id");
        ConsoleWriter.write("8 - Delete");
        ConsoleWriter.write("9 - Get All Books");
        ConsoleWriter.write("10 - Get All");
        ConsoleWriter.write("11 - Get All By User");
        ConsoleWriter.write("12 - Get All By Address");
        ConsoleWriter.write("13 - Get All By Store");
        ConsoleWriter.write("14 - Get By Id");
    }

    private void addressMenu(){
        ConsoleWriter.write("0 - Back");
        ConsoleWriter.write("1 - Save");
        ConsoleWriter.write("2 - Update Street");
        ConsoleWriter.write("3 - Update Home");
        ConsoleWriter.write("4 - Delete");
        ConsoleWriter.write("5 - Delete By Id");
        ConsoleWriter.write("6 - Delete By Street");
        ConsoleWriter.write("7 - Get All By Home");
        ConsoleWriter.write("8 - Get By Id");
        ConsoleWriter.write("9 - Get All");
    }

    private void bookMenu(){
        ConsoleWriter.write("0 - Back");
        ConsoleWriter.write("1 - Save");
        ConsoleWriter.write("2 - Delete");
        ConsoleWriter.write("3 - Update Title");
        ConsoleWriter.write("4 - Update Description");
        ConsoleWriter.write("5 - Update Price");
        ConsoleWriter.write("6 - Update Author");
        ConsoleWriter.write("7 - Get By Id");
        ConsoleWriter.write("8 - Get By Title");
        ConsoleWriter.write("9 - Get All");
        ConsoleWriter.write("10 - Get All By Author");
        ConsoleWriter.write("11 - Get All By Price");
    }

    private void userMenu() {
        ConsoleWriter.write("0 - Logout");
        ConsoleWriter.write("1 - Search book by author");
        ConsoleWriter.write("2 - Find all books");
        ConsoleWriter.write("3 - Find all books by price");
        ConsoleWriter.write("4 - Basket");
        ConsoleWriter.write("5 - Profile");
        ConsoleWriter.write("6 - Orders");
    }

    private void adminMenu() {
        ConsoleWriter.write("0 - Logout");
        ConsoleWriter.write("1 - Book menu");
        ConsoleWriter.write("2 - Order menu");
        ConsoleWriter.write("3 - Address menu");
        ConsoleWriter.write("4 - Author menu");
        ConsoleWriter.write("5 - User menu");
    }
}
