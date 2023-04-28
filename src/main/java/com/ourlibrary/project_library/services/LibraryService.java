package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.LibraryDTO;
import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Library;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.entities.Teacher;
import com.ourlibrary.project_library.repositories.BookRepository;
import com.ourlibrary.project_library.repositories.LibraryRepository;
import com.ourlibrary.project_library.repositories.StudentRepository;
import com.ourlibrary.project_library.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final BookRepository bookRepository;


    public LibraryDTO insert(Library library){
        Student student = new Student();
        Teacher teacher = new Teacher();
        Book book = new Book();
        if (library.getStudents() != null){
            for (int i = 0; i < library.getStudents().size(); i++) {
                student = studentRepository.findById(library.getStudents().get(i).getId()).orElseThrow(
                        ()-> new ObjectNotFoundException("Student not found"));

            }
        }
        if(library.getTeachers() != null){
            for (int i = 0; i < library.getTeachers().size(); i++){
                teacher = teacherRepository.findById(library.getTeachers().get(i).getId()).orElseThrow(
                        ()-> new ObjectNotFoundException("Teacher not found"));
            }
        }
        if(library.getBooks() != null) {
            for (int i = 0; i < library.getBooks().size(); i++){
                book = bookRepository.findByIsbn(library.getBooks().get(i).getIsbn()).orElseThrow(
                        ()-> new ObjectNotFoundException("Book not found"));
            }
        }

        LibraryDTO dto = new LibraryDTO();
        dto.setName_Student(student.getName_user());
        dto.setLibrary_name(library.getLibrary_name());
        dto.setName_Teacher(teacher.getName_user());
        dto.setName_book(book.getName());
        dto.setInstitution_name(library.getInstitution_name());

        libraryRepository.save(library);
        return dto;
    }

    public Library getLibrary(Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(()->new ObjectNotFoundException("id not found"));
    }
}
