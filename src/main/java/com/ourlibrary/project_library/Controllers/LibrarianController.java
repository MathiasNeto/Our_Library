package com.ourlibrary.project_library.Controllers;

import com.ourlibrary.project_library.dto.UserDTO;
import com.ourlibrary.project_library.entities.*;
import com.ourlibrary.project_library.services.*;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/librarian")
@RequiredArgsConstructor
public class LibrarianController {
    private final StudentService studentService;
    private final CourseService courseService;
    private final BookService bookService;
    private final ContactService contactService;
    private final LoanService loanService;

    private Validator validator;


    @PostMapping(value = "/student")
    public ResponseEntity<Student> insertStudent(@RequestBody @Valid Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.insert(student));
    }

    @GetMapping(value = "/allStudent")
    public ResponseEntity<List<UserDTO>> findAllStudents() {
        List<UserDTO> userDTOList = studentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(userDTOList);
    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable @Valid Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }


    @GetMapping(value = "/allCourse")
    public ResponseEntity<List<Course>> findAllCourse() {
        List<Course> courseList = courseService.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(courseList);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping(value = "/allContact")
    public ResponseEntity<Contact> findAllContact() {
        return ResponseEntity.ok((Contact) contactService.findAll());
    }

    @GetMapping(value = "/contacts/{id}")
    public ResponseEntity<List<Contact>> getContact(@PathVariable @Valid Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findAll());
    }

    @DeleteMapping(value = "/delContact/{id}")
    public void deleteId(@PathVariable Long id) {
        contactService.delete(id);
    }


    @PostMapping(value = "/book")
    public ResponseEntity<Book> insertBook(@RequestBody @Valid Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.insert(book));
    }

    @GetMapping(value = "/allBook")
    public ResponseEntity<List<Book>> findAllBook(Book book) {
        List<Book> bookList = bookService.findAll(book);
        return ResponseEntity.ok(bookList);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping(value = "/loan")
    public ResponseEntity<Loan> accomplish(@RequestBody Loan loan){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.insert(loan));
    }
}
