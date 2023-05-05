package com.ourlibrary.project_library.testsUntil;

import com.ourlibrary.project_library.dto.StudentDTO;
import com.ourlibrary.project_library.entities.*;
import com.ourlibrary.project_library.enuns.Area;
import com.ourlibrary.project_library.enuns.EnumGender;
import com.ourlibrary.project_library.repositories.StudentRepository;
import com.ourlibrary.project_library.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class TestStudentRepository {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    public Student student;

    @Test
    public void testFindAllStudents() {
        this.student = new Student("7", new Course(null, Area.EXACT_SCIENCES, "Computer Science")
                , "18954707068", "ntest", EnumGender.MASCULINE, new Address("Rua dos bobos", "3", "cidade abadon" +
                "ada", "PB", "bairro das freiras"), new Contact(null, "iran7826@uorak.com", "832367273", student), new Login(null, "625655", "csdljvbljvlcjn")
        );
        studentRepository.save(student);
        StudentDTO studentDTO = new StudentDTO(student);
        // Executa o método de busca de todos os estudantes no serviço de estudante
        List<Student> students = studentRepository.findAll();

        // Verifica se a lista de estudantes contém os dois estudantes criados anteriormente
        assertEquals(1, students.size());
        assertTrue(students.contains(student));
    }

    @Test
    public void testFindByIdStudent(){

        this.student = new Student("7", new Course(null, Area.EXACT_SCIENCES, "Computer Science")
                , "18954707068", "ntest", EnumGender.MASCULINE, new Address("Rua dos bobos", "3", "cidade abadon" +
                "ada", "PB", "bairro das freiras"), new Contact(null, "iran7826@uorak.com", "832367273", student), new Login(null, "625655", "csdljvbljvlcjn")
        );
        studentRepository.save(student);
        Long id = studentService.findById(student.getId()).getId();
        assertEquals(1, id);

    }
}