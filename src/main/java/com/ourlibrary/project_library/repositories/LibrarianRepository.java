package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

    boolean existsByCpf(String cpf);

}
