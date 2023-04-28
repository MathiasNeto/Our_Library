package com.ourlibrary.project_library;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.enuns.Area;
import com.ourlibrary.project_library.repositories.BookRepository;
import com.ourlibrary.project_library.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;
    public Book book;


    @BeforeEach
    public void testCreatorBook() {
        this.book = new Book();
        book.setName("POO");
        book.setIsbn("8717872-0");
        book.setArea(Area.valueOf("HUMAN"));
        book.setIsAvailable(true);
    }
    @Test
    void test_Checks_if_Saved(){
        bookRepository.save(book);

        assertNotNull(book.getIsbn());
        assertEquals("POO", book.getName());
        assertEquals("8717872-0", book.getIsbn());
        assertEquals(Area.valueOf("HUMAN"), book.getArea());
        assertEquals(true, book.getIsAvailable());
    }


    @Test
    public void givenExistingBook_whenEditBook_thenBookIsUpdated() { //given-when-then

        this.book = new Book();
        book.setName("POO");
        book.setIsbn("8717872-0");
        book.setArea(Area.HUMAN);
        book.setIsAvailable(true);
        bookRepository.save(book);


        book.setName("C++");
        bookRepository.save(book);

        Book updatedBook = bookRepository.findById(book.getIsbn()).orElse(null);
        assertNotNull(updatedBook);
        assertEquals("C++", updatedBook.getName());
        assertEquals("8717872-0", updatedBook.getIsbn());
        assertEquals(Area.HUMAN, updatedBook.getArea());
        assertEquals(true, updatedBook.getIsAvailable());
    }
    @Test
    public void testDeleteBook() {

        Book book = new Book();
        book.setName("Livro de Teste");
        book.setArea(Area.HUMAN);
        book.setIsbn("1234567890");
        book.setIsAvailable(true);
        bookRepository.save(book);


        bookService.deleteBookById(book.getIsbn());

        Optional<Book> deletedBook = bookRepository.findByIsbn(book.getIsbn());
        assertFalse(deletedBook.isPresent());
    }

    @Test
    public void testFindAllBooks(){
        this.book = new Book();
        book.setName("Python");
        book.setIsAvailable(true);
        book.setIsbn("109289839");
        book.setArea(Area.HUMAN);

        bookRepository.save(book);

        List<Book> allBooks = bookService.findAll(book);

        assertTrue(allBooks.contains(book));
    }
}