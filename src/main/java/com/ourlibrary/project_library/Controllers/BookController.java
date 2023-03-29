package com.ourlibrary.project_library.Controllers;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity<Book> insert(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(book));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Book>> findAll(Book book){
        List<Book> bookList = service.findAll(book);
        return ResponseEntity.ok(bookList);
    }

    @GetMapping(value = "/findById/{isbn}")
    public ResponseEntity<Book> findById(@PathVariable String isbn){
        return ResponseEntity.ok(service.findById(isbn));
    }
 }
