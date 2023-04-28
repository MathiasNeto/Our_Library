package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.Library;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDTO {
    private String library_name;
    private String institution_name;

    private String name_librarian;

    private String name_book;
    private String name_Student;
    private String name_Teacher;

    public LibraryDTO(Library library){
        library_name = library.getLibrary_name();
        institution_name = library.getInstitution_name();
        name_librarian = library.getLibrarian().getName_user();
        for (int i = 0; i < library.getBooks().size(); i++) {
            name_book = library.getBooks().get(i).getName();
        }
    }
}
