package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.BookDTO;
import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Librarian;
import com.ourlibrary.project_library.entities.Library;
import com.ourlibrary.project_library.repositories.BookRepository;
import com.ourlibrary.project_library.repositories.LibrarianRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private Validator validator;



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

    @Transactional(readOnly = true) //Diz que é só uma operacao de leitura no banco, isso deixa a consulta mais rapida
    public BookDTO findById(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(() -> new ObjectNotFoundException(
                "id " + isbn +
                " Not FOUND"));
        return new BookDTO(book);
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