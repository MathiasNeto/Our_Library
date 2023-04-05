package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Librarian;
import com.ourlibrary.project_library.enuns.EnumGender;
import lombok.Data;

@Data
public class BookDTO {
    private String name;

    private String isbn;
    private String isAvailable;
    public BookDTO(Book book){
        name = book.getName();
        isbn = book.getIsbn();
        isAvailable = book.getIsAvailable().toString();
    }
}
