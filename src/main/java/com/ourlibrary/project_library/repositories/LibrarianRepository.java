package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

}
