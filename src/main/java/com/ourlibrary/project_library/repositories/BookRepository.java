package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,String> {
    boolean existsByIsbn(String isbn);

    Optional<Book> isAvailable(Boolean aBoolean);

    //@Query("SELECT b FROM Book b WHERE b.isbn =:isbn AND b.area =:area and b.name =:name")
    //Optional<Book> findBookBy(String isbn, Area area, String name);
    Optional<Book> findByIsbn(String isbn);
}
