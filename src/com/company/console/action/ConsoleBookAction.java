package com.company.console.action;

import com.company.console.util.ConsoleReader;
import com.company.console.util.ConsoleWriter;
import com.company.entity.Author;
import com.company.entity.Book;
import com.company.service.AuthorService;
import com.company.service.AuthorServiceImpl;
import com.company.service.BookService;
import com.company.service.BookServiceImpl;
import com.company.storage.InMemoryBookStorage;

public class ConsoleBookAction implements BookAction {

    private BookService bookService = new BookServiceImpl();
    private AuthorService authorService = new AuthorServiceImpl();

    @Override
    public void save() {
        ConsoleWriter.write("Enter title");
        String title = ConsoleReader.readString();
        ConsoleWriter.write("Enter descriptions");
        String descriptions = ConsoleReader.readString();
        ConsoleWriter.write("Choose author");
        Author[] all = authorService.getAll();
        for (int i = 0; i < all.length; i++) {
            if(all[i] == null) break;
            ConsoleWriter.write((i + 1) + " Author " + all[i].getName());
        }
        int i = ConsoleReader.readInt() - 1;
        Author author = all[i];
        ConsoleWriter.write("Enter price");
        double price = ConsoleReader.readDouble();
        Book book = new Book(title, descriptions, author, price);
        boolean save = bookService.save(book);
        if (save) {
            ConsoleWriter.write("Done");
        } else {
            ConsoleWriter.write("This address is exist!");
        }
    }

    @Override
    public void delete() {
        Book[] all = bookService.getAll();
        ConsoleWriter.write("Choose book:");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Title " + all[i].getTitle() + " descriptions" + all[i].getDescription() + " author " + all[i].getAuthor() + " price " + all[i].getPrice());
        }
        int i = ConsoleReader.readInt() - 1;
        bookService.delete(all[i].getId());
    }

    @Override
    public void updateTitle() {
        Book[] all = bookService.getAll();
        ConsoleWriter.write("Choose title");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Author " + all[i].getAuthor() + " title " + all[i].getTitle());
        }
        int i = ConsoleReader.readInt() - 1;
        ConsoleWriter.write("Write new title");
        String title = ConsoleReader.readString();
        String title1 = bookService.updateTitle(all[i].getId(), title);
        ConsoleWriter.write(title1 + " was changed to " + title);
    }

    @Override
    public void updateDescription() {
        Book[] all = bookService.getAll();
        ConsoleWriter.write("Choose description");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Author " + all[i].getAuthor() + " title " + all[i].getTitle() + " description " + all[i].getDescription());
        }
        int i = ConsoleReader.readInt() - 1;
        ConsoleWriter.write("Write new description");
        String description = ConsoleReader.readString();
        String description1 = bookService.updateDescription(all[i].getId(), description);
        ConsoleWriter.write(description1 + " was changed to " + description);
    }

    @Override
    public void updatePrice() {
        Book[] all = bookService.getAll();
        ConsoleWriter.write("Choose price");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Author " + all[i].getAuthor() + " title " + all[i].getTitle() + " description " + all[i].getDescription() + " price " + all[i].getPrice());
        }
        int i = ConsoleReader.readInt() - 1;
        ConsoleWriter.write("Write new price");
        double price = ConsoleReader.readDouble();
        double price1 = bookService.updatePrice(all[i].getId(), price);
        ConsoleWriter.write(price1 + " was changed to " + price);
    }

    @Override
    public void updateAuthor() {
        Author[] allAuthor = authorService.getAll();
        Book[] all = bookService.getAll();
        ConsoleWriter.write("Choose Book");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + all[i].getTitle());
        }
        int bookId = ConsoleReader.readInt() - 1;
        Book book = all[bookId];
        ConsoleWriter.write("Choose author");
        for (int i = 0; i < allAuthor.length; i++) {
            ConsoleWriter.write((i + 1) + allAuthor[i].getName());
        }
        int authorId = ConsoleReader.readInt() - 1;
        Author author1 = allAuthor[authorId];
        Author author = bookService.updateAuthor(book.getId(), author1);
        ConsoleWriter.write(author.getName() + " was changed to " + author1.getName());
    }

    @Override
    public void getById() {
        ConsoleWriter.write("Enter id");
        int i1 = ConsoleReader.readInt();
        Book byId = bookService.getById(i1);
        ConsoleWriter.write("Author " + byId.getAuthor() + " title " + byId.getTitle() + " description " + byId.getDescription() + " price " + byId.getPrice());
    }

    @Override
    public void getByTitle() {
        Book[] all = bookService.getAll();
        ConsoleWriter.write("Enter title");
        String s = ConsoleReader.readString();
        Book byTitle = bookService.getByTitle(s);
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write("Id " + byTitle.getId() + " author " + byTitle.getAuthor() + " title " + byTitle.getTitle() + " description " + byTitle.getDescription() + " price " + byTitle.getPrice());
        }
    }

    @Override
    public void getAll() {
        Book[] all = bookService.getAll();
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write("Id " + all[i].getId() + " author " + all[i].getAuthor() + " title " + all[i].getTitle() + " description " + all[i].getDescription() + " price " + all[i].getPrice());
        }
    }

    @Override
    public void getAllByAuthor() {
        Author[] allAuthors = authorService.getAll();
        ConsoleWriter.write("Choose author");
        for (int i = 0; i < allAuthors.length; i++) {
            ConsoleWriter.write((i + 1) + allAuthors[i].getName());
        }
        int id = ConsoleReader.readInt() - 1;
        Author author = authorService.getById(id);
        Book[] allByAuthor = bookService.getAllByAuthor(author);
        for (int i = 0; i < allByAuthor.length; i++) {
            ConsoleWriter.write("Id " + allByAuthor[i].getId() + " title " + allByAuthor[i].getTitle() + " descriptions " + allByAuthor[i].getDescription() + " price " + allByAuthor[i].getPrice());
        }
    }

    @Override
    public void getAllByPrice() {
        ConsoleWriter.write("Enter price");
        double price = ConsoleReader.readDouble();
        Book[] allByPrice = bookService.getAllByPrice(price);
        for (int i = 0; i < allByPrice.length; i++) {
            ConsoleWriter.write("Id " + allByPrice[i].getId() + " author " + allByPrice[i].getAuthor() + " title " + allByPrice[i].getTitle() + " description " + allByPrice[i].getDescription());
        }
    }
}
