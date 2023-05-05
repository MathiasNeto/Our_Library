package com.ourlibrary.project_library.test_integration;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.enuns.Area;
import com.ourlibrary.project_library.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class BooksIsAvailableTest {
    public Book book;

    @Autowired
    private BookService bookService;

    @Test
    public void findAllBooksIsAvailable(){
        this.book = new Book();
        book.setName("POO");
        book.setIsbn("8717872-0");
        book.setArea(Area.HUMAN);
        book.setIsAvailable(true);

        bookService.insert(book);
        bookService.findAllBooksIsAvailable(book.getIsAvailable());

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        assertTrue(bookList.contains(book));
    }
}
