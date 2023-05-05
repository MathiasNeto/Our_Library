package com.ourlibrary.project_library.test_integration;

import com.ourlibrary.project_library.entities.*;
import com.ourlibrary.project_library.enuns.Area;
import com.ourlibrary.project_library.enuns.EnumGender;
import com.ourlibrary.project_library.repositories.StudentRepository;
import com.ourlibrary.project_library.services.BookService;
import com.ourlibrary.project_library.services.LoanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class LoanRepositoryTest {
    public Student student;
    public Book book;
    public Loan loan;
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LoanService loanService;
    @Test
    public void testCreateLoan(){
        this.student = new Student("7", new Course(null, Area.EXACT_SCIENCES, "Computer Science")
                , "18954707068", "ntest", EnumGender.MASCULINE, new Address("Rua dos bobos", "3", "cidade abadon" +
                "ada", "PB", "bairro das freiras"), new Contact(null, "iran7826@uorak.com", "832367273", student), new Login(null, "625655", "csdljvbljvlcjn")
        );

        this.book = new Book();
        book.setName("POO");
        book.setIsbn("8717872-0");
        book.setArea(Area.valueOf("HUMAN"));
        book.setIsAvailable(true);
        this.loan = new Loan();
        loan.setStudent(student);
        loan.setLoanDate(LocalDate.now());
        loan.setBook(book);
        loan.setStatus("borrowed ");
        loan.setDate_devolution(loan.getLoanDate().plusDays(5));

        studentRepository.save(student);
        bookService.insert(book);
        loanService.insert(loan);

        assertNotNull(loan.getId());
        assertEquals(false, bookService.findById(book.getIsbn()).getIsAvailable());

    }

}
