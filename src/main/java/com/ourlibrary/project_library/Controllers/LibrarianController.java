package com.ourlibrary.project_library.Controllers;

import com.ourlibrary.project_library.dto.BookDTO;
import com.ourlibrary.project_library.dto.LoanDTO;
import com.ourlibrary.project_library.dto.StudentDTO;
import com.ourlibrary.project_library.dto.TeacherDTO;
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
    private final LoginService loginService;

    private Validator validator;


    @PostMapping(value = "/student")
    public ResponseEntity<StudentDTO> insertStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.insert(student));
    }

    @GetMapping(value = "/allStudent")
    public ResponseEntity<List<StudentDTO>> findAllStudents() {
        List<StudentDTO> studentDTOList = studentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(studentDTOList);
    }

    @GetMapping(value = "/getStudents/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }

    @PostMapping(value = "/teacher")
    public ResponseEntity<TeacherDTO> insertTeacher(@Valid @RequestBody Teacher teacher) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.insert(teacher));
    }


    @GetMapping(value = "/allCourse")
    public ResponseEntity<List<Course>> findAllCourse() {
        List<Course> courseList = courseService.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(courseList);
    }

    @GetMapping(value = "/getCourses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping(value = "/allContact")
    public ResponseEntity<Contact> findAllContact() {
        return ResponseEntity.ok((Contact) contactService.findAll());
    }

    @GetMapping(value = "/getContacts/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findById(id));
    }

    @DeleteMapping(value = "/delContact/{id}")
    public void deleteId(@PathVariable Long id) {
        contactService.delete(id);
    }


    @PostMapping(value = "/book")
    public ResponseEntity<BookDTO> insertBook(@Valid @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.insert(book));
    }

    @GetMapping(value = "/allBook")
    public ResponseEntity<List<Book>> findAllBook() {
        List<Book> bookList = bookService.findAll();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping(value = "/getBook/{isbn}")
    public ResponseEntity<BookDTO> getBook(@PathVariable String isbn) {
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
    public ResponseEntity<LoanDTO> accomplish(@RequestBody @Valid Loan loan) {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.insert(loan));
    }

    @PostMapping(value = "/devolution")
    public ResponseEntity<Devolution> accomplish(@RequestBody @Valid Devolution devolution) {
        return ResponseEntity.status(HttpStatus.OK).body(devolutionService.insert(devolution));
    }
    @PostMapping(value = "/login")
    public ResponseEntity login (@RequestBody Login login ){
        try {
            Users p = loginService.search(login.getEmail(),login.getPassword());
            System.out.println(p.getId());
            return ResponseEntity.ok(p);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
}


}
}
