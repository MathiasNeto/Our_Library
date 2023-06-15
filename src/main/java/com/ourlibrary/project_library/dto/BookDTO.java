package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.enuns.Area;
import lombok.Data;

@Data

public class BookDTO {
    private String name;
    private Area area;

    public BookDTO(Book book){
        name = book.getName();
        area = book.getArea();
    }
}
