package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<Book,Long> {
    boolean existsByIsbn(String isbn);
}
