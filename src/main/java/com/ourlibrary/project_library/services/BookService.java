package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.repositories.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRespository repository;

    public Book insert(Book book){
        return repository.save(book);
    }

    public List<Book> findAll(Book book) {
        return repository.findAll();
    }

    public Book findById(String isbn){
        Book book = repository.findById(isbn).get(); //.get() pq ele retorna um optional e para pegar
        // um valor do tipo optional usei o get
        return book; //depois criar o dto se precisar
    }

}
