package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Library;
import com.ourlibrary.project_library.repositories.LibraryRepository;
import com.ourlibrary.project_library.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final StudentRepository studentRepository;


    public Library insert(Library library){

        if (library.getStudents() != null) {
            for (int i = 0; i < library.getStudents().size(); i++) {
                if (!studentRepository.existsById(library.getStudents().get(i).getId())) {
                    throw new ObjectNotFoundException("Student which id = " + library.getStudents().get(i) + " not found");
                }
            }
        }


        return libraryRepository.save(library);
    }

    public Library getAll(Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(()->new ObjectNotFoundException("id "+ id +" not found"));
    }
}
