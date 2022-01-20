package com.dxc;

import java.sql.SQLException;
import java.util.List;
import com.dxc.dao.BookDao;
import com.dxc.model.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        ctx.refresh();

        Book animalFarm = new Book("Animal", "john", "12345");
        Book dune = new Book("Dune", "Frank ", "97878");
        Book theHobbit = new Book("The Hobbit", "Tolkien", "97896");
        Book theLordOfTheRings =
                new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0-395-19395-8");
        Book theSilmarillion = new Book("The Silmarillion", "J.R.R. Tolkien", "978-0-395-19395-8");
        Book theChroniclesOfNarnia =
                new Book("The Chronicles of Narnia", "Lewis", "19395");

        List<Book> books = List.of(animalFarm, dune, theHobbit, theLordOfTheRings, theSilmarillion,
                theChroniclesOfNarnia);

        BookDao bookDao = ctx.getBean("bookDao", BookDao.class);

        books.forEach(bk -> {
            try {
                int rows = bookDao.save(bk);
                System.out.println("Rows affected: " + rows);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        });

        try {
            bookDao.findAll().forEach(System.out::println);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        ctx.registerShutdownHook();
    }
}