package com.dxc.learning.demo1.service;

import java.util.List;
import com.dxc.learning.demo1.model.Author;

public interface Authorservice {

    public Author getAuthorById(int id);
    
    public Author getAuthorByname(String name);

    public Author getAuthorByEmail(String email);

    public Author createAuthor(Author author);

    public Author updateAuthor(Author author);

    public void deleteAuthor(int id);

    public List<Author> getAllAuthors();

    
}
