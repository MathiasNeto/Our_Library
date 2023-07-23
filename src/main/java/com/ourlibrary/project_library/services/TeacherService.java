package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.TeacherDTO;
import com.ourlibrary.project_library.entities.Course;
import com.ourlibrary.project_library.services.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.services.Excetions.ObjetDuplicator;
import com.ourlibrary.project_library.entities.Teacher;
import com.ourlibrary.project_library.repositories.ContactRepository;
import com.ourlibrary.project_library.repositories.CourseRepository;
import com.ourlibrary.project_library.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final ContactRepository contactRepository;
    private final CourseRepository courseRepository;
    public TeacherDTO insert(Teacher teacher) {
        Course course;
        if (teacherRepository.existsByCpf(teacher.getCpf())) {
            throw new ObjetDuplicator("CPF Duplicator ");
        }
        for (int i = 0; i < teacher.getContactList().size(); i++) {
            teacher.getContactList().get(i).setUser(teacher);
            if (contactRepository.existsByEmail(teacher.getContactList().get(i).getEmail())) {
                throw new ObjetDuplicator("Email UNIQUE");
            }
        }

        // Busca o curso pelo nome e área
        Optional<Course> optionalCourse = courseRepository.findByAreaAndName(teacher.getCourse().getArea(), teacher.getCourse().getName());

        if (optionalCourse.isPresent()) {
            // Se o curso já existe, usa o curso encontrado
            course = optionalCourse.get();
        } else {
            // Se o curso não existe, cria um novo curso
            course = new Course();
            course.setArea(teacher.getCourse().getArea());
            course.setName(teacher.getCourse().getName());
            course = courseRepository.save(course);
        }
        teacher.setCourse(course);


        teacherRepository.save(teacher);

        return new TeacherDTO(teacher);
    }

    public List<TeacherDTO> findAll() {
        List<Teacher> list = teacherRepository.findAll();
        return list
                .stream()
                .map(TeacherDTO::new)
                .collect(Collectors
                        .toList());
    }

    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Entity not found"));
    }
}
