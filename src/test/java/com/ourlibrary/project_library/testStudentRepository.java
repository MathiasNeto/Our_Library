package com.ourlibrary.project_library;

import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.repositories.StudentRepository;
import com.ourlibrary.project_library.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class testStudentRepository {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    public Student student;
    @Test
    public void testFindAllStudents() {
        Student student1 = new Student();
        student1.setName("João");
        student1.setRegistration("123456");
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setName("Maria");
        student2.setRegistration("789012");
        studentRepository.save(student2);

        // Executa o método de busca de todos os estudantes no serviço de estudante
        List<Student> students = studentService.findAllStudents();

        // Verifica se a lista de estudantes contém os dois estudantes criados anteriormente
        assertEquals(2, students.size());
        assertTrue(students.contains(student1));
        assertTrue(students.contains(student2));
    }
}
