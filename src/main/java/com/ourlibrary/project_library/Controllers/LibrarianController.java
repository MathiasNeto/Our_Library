package com.ourlibrary.project_library.Controllers;

import com.ourlibrary.project_library.dto.BookDTO;
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
    private final TeacherService teacherService;
    private final DevolutionService devolutionService;

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

    @GetMapping(value = "/getStudents/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable @Valid Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }

    @PostMapping(value = "/teacher")
    public ResponseEntity<Teacher> insertTeacher(@RequestBody @Valid Teacher teacher){
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.insert(teacher));
    }


    @GetMapping(value = "/allCourse")
    public ResponseEntity<List<Course>> findAllCourse() {
        List<Course> courseList = courseService.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(courseList);
    }

    @GetMapping(value = "/getCourses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping(value = "/allContact")
    public ResponseEntity<Contact> findAllContact() {
        return ResponseEntity.ok((Contact) contactService.findAll());
    }

    @GetMapping(value = "/getContacts/{id}")
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

    @GetMapping(value = "/getBooks/{isbn}")
    public ResponseEntity<BookDTO> getBook(@PathVariable @Valid String isbn) {
        return ResponseEntity.ok(bookService.findById(isbn));
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        bookService.deleteBookById(isbn);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/bookUpdate/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn, @Valid @RequestBody Book book) {
        book.setIsbn(isbn);
        Book updatedBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }


    @PostMapping(value = "/loan")
    public ResponseEntity<Loan> accomplish(@RequestBody Loan loan){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.insert(loan));
    }
    @PostMapping(value = "/Devolution")
    public ResponseEntity<Devolution> accomplish(@RequestBody Devolution devolution){
        return ResponseEntity.status(HttpStatus.OK).body(devolutionService.insert(devolution));
    }

}
