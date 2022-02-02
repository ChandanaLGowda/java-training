package com.dxc.learning.demo1.controllers;

import java.util.List;
import java.time.LocalDate;
import com.dxc.learning.demo1.model.Author;
import com.dxc.learning.demo1.repository.AuthorRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

  private final AuthorRepository repository;

  AuthorController(AuthorRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/authors")
 public List<Author> all() {
    return repository.findAll();
  }

  @PostMapping("/authors")
public  Author newAuthor(@RequestBody Author newAuthor) {
  newAuthor.setCreationDate(LocalDate());
    return repository.save(newAuthor);
  }

  private LocalDate LocalDate() {
    return null;
  }

  @GetMapping("/authors/{id}")
 public Author one(@PathVariable Integer id) {

    return repository.findById(id)
        .orElseThrow(() -> new AuthorNotFoundException(id));
  }

  @PutMapping("/authors/{id}")
  public Author replaceAuthor(@RequestBody Author newAuthor, @PathVariable Integer id) {

    return repository.findById(id)
        .map(author -> {
          author.setName(newAuthor.getName());
          author.setEmail(newAuthor.getEmail());
          author.setCreationDate(LocalDate.now());
          return repository.save(author);
        })
        .orElseGet(() -> {
          newAuthor.setId(id);
          return repository.save(newAuthor);
        });
  }

  @DeleteMapping("/authors/{id}")
 public void deleteAuthor(@PathVariable Integer id) {
    repository.deleteById(id);
  }
}
  


  