package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Library;
import com.ourlibrary.project_library.repositories.BookRepository;
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

    private final BookRepository bookRepository;
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

    public Book findById(String isbn) {
        return bookRepository.findById(String.valueOf(isbn)).orElseThrow(() -> new ObjectNotFoundException("id " + isbn +
                " Not FOUND"));
        //depois
        // criar o dto se precisar
    }

    public void deleteBookById(String isbn) {
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        if (bookOptional.isPresent()) {
            bookRepository.delete(bookOptional.get());
        } else {
            throw new EntityNotFoundException("Book with id " + isbn + " not found.");
        }
    }

    public Book updateBook(@Valid Book updatedBook) {
        Book existingBook = bookRepository.findByIsbn(updatedBook.getIsbn())
                .orElseThrow(() -> new ObjectNotFoundException("Book with ISBN " + updatedBook.getIsbn() + " not found."));

        existingBook.setName(updatedBook.getName());
        existingBook.setArea(updatedBook.getArea());
        existingBook.setIsbn(updatedBook.getIsbn());

        return bookRepository.save(existingBook);
    }

}