package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.Book;
import lombok.Data;

@Data

public class BookDTO {
    private String name;
    private Boolean isAvailable;

    public BookDTO(Book book){
        name = book.getName();
        isAvailable = book.getIsAvailable();
    }
}
