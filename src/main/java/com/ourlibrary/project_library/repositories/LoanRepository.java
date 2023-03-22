package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
