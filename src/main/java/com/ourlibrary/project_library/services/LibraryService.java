package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Library;
import com.ourlibrary.project_library.repositories.LibraryRepository;
import com.ourlibrary.project_library.repositories.bookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public Library insert(Library library){
        return libraryRepository.save(library);
    }
}
