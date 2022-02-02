package com.dxc.learning.demo1.service;

import java.util.List;
import com.dxc.learning.demo1.model.Author;

public interface Authorservice {

    public Author getUserById(int id);
    
    public Author getUserByname(String name);

    public Author getUserByEmail(String email);

    public Author createAuthor(Author author);

    public Author updateAuthor(Author author);

    public void deleteAuthor(int id);

    public List<Author> getAllAuthors();

    
}
