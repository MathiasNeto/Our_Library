package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT COUNT(l) > 0 FROM Loan l WHERE l.book = :book")
    boolean existsByBook(@Param("book") Book book);
}
