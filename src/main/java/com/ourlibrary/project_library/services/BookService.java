package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.BookDTO;
import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.services.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.services.Excetions.ObjetDuplicator;
import com.ourlibrary.project_library.repositories.BookRepository;
import com.ourlibrary.project_library.repositories.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;



    public BookDTO insert(BookDTO book)  {

        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new ObjetDuplicator("ISBN duplicator: " + book.getIsbn());
        }
        book.setIsAvailable(true);
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
        try {
            Book book = bookRepository.findById(isbn)
                    .orElseThrow(() -> new ObjectNotFoundException("Book not found"));

            if (loanRepository.existsByBook(book)) {
                throw new IllegalStateException("Cannot delete the book because it is referenced in loans.");
            }

            bookRepository.deleteById(isbn);

        } catch (IllegalStateException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("Failed to delete the book.", ex);
        }
    }


        /*
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        if (bookOptional.isPresent()) {
            bookRepository.delete(bookOptional.get());
        } else {
            throw new EntityNotFoundException("Book with id " + isbn + " not found.");
        }
         */


//    public Book updateBook(Book book) {
////        Book existingBook = bookRepository.findByIsbn(b)
////                .orElseThrow(() -> new ObjectNotFoundException("Book with ISBN " + isbn + " not found."));
////
////        existingBook.setName(existingBook.getName());
////        existingBook.setArea(existingBook.getArea());
//
//        return bookRepository.save(existingBook);
//    }

}