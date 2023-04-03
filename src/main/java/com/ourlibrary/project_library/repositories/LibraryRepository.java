package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Librarian;
import com.ourlibrary.project_library.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {

}
