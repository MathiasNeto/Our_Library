package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Librarian;
import com.ourlibrary.project_library.entities.Library;
import com.ourlibrary.project_library.repositories.bookRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BookService {

    private final bookRepository bookRepository;
    private Validator validator;

    private Library library;

    public Book insert(@Valid Book book) {

        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new ObjectNotFoundException("ISBN duplicator: " + book.getIsbn());
        }
        else {
            return bookRepository.save(book);
        }
    }

    public List<Book> findAll(Book book) {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("id " + id + " Not FOUND"));
        //depois
        // criar o dto se precisar
    }

    public void deleteBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.delete(bookOptional.get());
        } else {
            throw new EntityNotFoundException("Book with id " + id + " not found.");
        }
    }

//    public void updateBook( Long id){
//        Book book = new Book();
//        book.setBook_name(book.getBook_name());
//        book.setArea(book.getArea());
//        book.setIsbn(book.getBook_name());
//        bookRepository.save(book);
//    }
}