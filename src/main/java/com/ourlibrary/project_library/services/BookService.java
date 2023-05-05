package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.BookDTO;
import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Excetions.ObjetDuplicator;
import com.ourlibrary.project_library.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;



    public BookDTO insert(Book book)  {

        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new ObjetDuplicator("ISBN duplicator: " + book.getIsbn());
        }
        bookRepository.save(book);
        return new BookDTO(book);

    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true) //Diz que é só uma operacao de leitura no banco, isso deixa a consulta mais rapida
    public BookDTO findById(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(() -> new ObjectNotFoundException(
                "id " + isbn +
                " Not FOUND"));
        return new BookDTO(book);
    }

    public List<Book> findAllBooksIsAvailable(boolean b){
        Book book = bookRepository.isAvailable(b).orElseThrow(()->new ObjectNotFoundException("No content"));

        List<Book> books = Arrays.asList(book);

        return books;
    }

    public void deleteBookById(String isbn) {
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        if (bookOptional.isPresent()) {
            bookRepository.delete(bookOptional.get());
        } else {
            throw new EntityNotFoundException("Book with id " + isbn + " not found.");
        }
    }

    public Book updateBook(Book updatedBook) {
        Book existingBook = bookRepository.findByIsbn(updatedBook.getIsbn())
                .orElseThrow(() -> new ObjectNotFoundException("Book with ISBN " + updatedBook.getIsbn() + " not found."));

        existingBook.setName(updatedBook.getName());
        existingBook.setArea(updatedBook.getArea());
        existingBook.setIsbn(updatedBook.getIsbn());

        return bookRepository.save(existingBook);
    }

}