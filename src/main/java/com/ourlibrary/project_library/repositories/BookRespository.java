package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Devolution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<Book,String> {
}
