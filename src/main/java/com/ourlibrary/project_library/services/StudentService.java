package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.UserDTO;
import com.ourlibrary.project_library.entities.Course;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.repositories.CourseRespository;
import com.ourlibrary.project_library.repositories.StudentRepository;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    private final CourseRespository courseRespository;


    public Student insert(Student student) {
        Course course = student.getCourse(); // obtém o objeto Course do Student

        if (course.getId() != null) { // verifica se o id do curso já existe
            course = courseRespository.findById(course.getId())
                    .orElseThrow(() -> new ObjectNotFoundException("Course not found"));
        } else {
            courseRespository.save(course); // salva o novo curso no banco de dados
        }

        student.setCourse(course);
        return studentRepository.save(student);
    }

    public List<UserDTO> findAll (){
        List<Student> list = studentRepository.findAll();
        return list.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public Student findById( Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Id not found"));
    }
}