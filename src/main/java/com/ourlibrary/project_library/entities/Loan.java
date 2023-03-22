package com.ourlibrary.project_library.entities;

import java.time.LocalDate;
import java.util.List;

public class Loan { //Emprestimo
    private Student student;
    private Teacher teacher;

    private LocalDate date;
    private List<Book> books;
}
