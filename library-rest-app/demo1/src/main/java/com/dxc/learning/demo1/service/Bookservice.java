package com.dxc.learning.demo1.service;

    import java.util.List;
import com.dxc.learning.demo1.model.Book;

public interface Bookservice {

    public Book getBookById(int id);

    public Book getBookBytitle(String title);

    public Book getBookByisbn(int isbn);

    public Book createBook(Book book);

    public Book updateBook(Book book);

    public void deleteBook(int id);

    public List<Book> getAllBooks();

}

