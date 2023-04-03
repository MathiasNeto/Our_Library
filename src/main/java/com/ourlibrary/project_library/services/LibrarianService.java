package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Librarian;
import com.ourlibrary.project_library.repositories.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;

    public Librarian insert(Librarian librarian){
        return librarianRepository.save(librarian);
    }
}
