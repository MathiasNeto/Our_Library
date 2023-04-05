package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Library;
import com.ourlibrary.project_library.repositories.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public Library insert(Library library){
        return libraryRepository.save(library);
    }

    public Library getAll(Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(()->new ObjectNotFoundException("id "+ id +" not found"));
    }
}
