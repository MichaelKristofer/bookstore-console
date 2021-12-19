package com.company.console.action;

import com.company.console.util.ConsoleReader;
import com.company.console.util.ConsoleWriter;
import com.company.entity.Author;
import com.company.service.AuthorService;
import com.company.service.AuthorServiceImpl;

public class ConsoleAuthorAction implements AuthorAction {

    private AuthorService authorService = new AuthorServiceImpl();

    @Override
    public void save() {
        ConsoleWriter.write("Enter name");
        String name = ConsoleReader.readString();
        ConsoleWriter.write("Enter description");
        String description = ConsoleReader.readString();
        Author author1 = new Author(name, description);
        if (authorService.save(author1)) {
            ConsoleWriter.write("Done");
        } else {
            ConsoleWriter.write("This author is exist!");
        }
    }

    @Override
    public void updateName() {
        Author[] all = authorService.getAll();
        ConsoleWriter.write("Choose author");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Name " + all[i].getName() + " description " + all[i].getDescription());
        }
        int i = ConsoleReader.readInt() - 1;
        ConsoleWriter.write("Enter new name");
        String name = ConsoleReader.readString();
        authorService.updateName(all[i].getId(), name);
    }

    @Override
    public void updateDescription() {
        Author[] all = authorService.getAll();
        ConsoleWriter.write("Choose author");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Name " + all[i].getName() + " description " + all[i].getDescription());
        }
        int i = ConsoleReader.readInt() - 1;
        ConsoleWriter.write("Enter new descriptions");
        String descriptions = ConsoleReader.readString();
        authorService.updateDescription(all[i].getId(), descriptions);
    }

    @Override
    public void delete() {
        Author[] all = authorService.getAll();
        ConsoleWriter.write("Choose author");
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Name " + all[i].getName() + " description " + all[i].getDescription());
        }
        int i = ConsoleReader.readInt() - 1;
        authorService.delete(all[i]);

    }

    @Override
    public void deleteById() {
        ConsoleWriter.write("Enter id");
        int id = ConsoleReader.readInt();
        authorService.delete(id);
    }

    @Override
    public void getById() {
    ConsoleWriter.write("Enter id");
    int id = ConsoleReader.readInt();
    Author byId = authorService.getById(id);
    ConsoleWriter.write("Name " + byId.getName() + " descriptions " + byId.getDescription());
    }

    @Override
    public void getAll() {
        Author[] all = authorService.getAll();
        for (int i = 0; i < all.length; i++) {
            ConsoleWriter.write((i + 1) + " Name " + all[i].getName() + " descriptions " + all[i].getDescription());
        }
    }

    @Override
    public void getByName() {
        ConsoleWriter.write("Enter name");
        String name = ConsoleReader.readString();
        Author byName = authorService.getByName(name);
        ConsoleWriter.write(" Id " + byName.getId() + " name " + byName.getName() + " descriptions " + byName.getDescription());
    }
}
