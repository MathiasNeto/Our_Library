package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.StudentDTO;
import com.ourlibrary.project_library.entities.Course;
import com.ourlibrary.project_library.services.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.services.Excetions.ObjetDuplicator;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.repositories.ContactRepository;
import com.ourlibrary.project_library.repositories.CourseRepository;
import com.ourlibrary.project_library.repositories.LoginRepository;
import com.ourlibrary.project_library.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ContactRepository contactRepository;
    private final LoginRepository loginRepository;
    private final CourseRepository courseRepository;
    public StudentDTO insert(Student student) {
        Course course;
//        Example<Course> courseExample = Example.of(course);
        if (studentRepository.existsByCpf(student.getCpf())) {
            throw new ObjetDuplicator("CPF UNIQUE");
        }
        for (int i = 0; i < student.getContactList().size(); i++) {
            student.getContactList().get(i).setUser(student);

            if (contactRepository.existsByEmail(student.getContactList().get(i).getEmail())) {
                throw new ObjetDuplicator("Email UNIQUE");
            }
        }
        if(loginRepository.existsByRegistration(student.getLogin().getRegistration())){
            throw new ObjetDuplicator("Registration UNIQUE");
        }
        // Busca o curso pelo nome e área
        Optional<Course> optionalCourse =
                courseRepository.findByAreaAndName(student.getCourse().getArea(), student.getCourse().getName());

        if (optionalCourse.isPresent()) {
            // Se o curso já existe, usa o curso encontrado
            course = optionalCourse.get();
        } else {
            // Se o curso não existe, cria um novo curso
            course = new Course();
            course.setArea(student.getCourse().getArea());
            course.setName(student.getCourse().getName());
            course = courseRepository.save(course);
        }
        student.setCourse(course);
        studentRepository.save(student);
        return new StudentDTO(student);
    }

    public List<StudentDTO> findAll() {
        List<Student> list = studentRepository.findAll();
        return list.stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id not found"));
    }
}