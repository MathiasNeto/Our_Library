package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.TeacherDTO;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Excetions.ObjetDuplicator;
import com.ourlibrary.project_library.entities.Teacher;
import com.ourlibrary.project_library.repositories.ContactRepository;
import com.ourlibrary.project_library.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final ContactRepository contactRepository;
    public Teacher insert(Teacher teacher) {
        for (int i = 0; i < teacher.getContactList().size(); i++) {
            teacher.getContactList().get(i).setUser(teacher);
            if (contactRepository.existsByEmail(teacher.getContactList().get(i).getEmail())) {
                throw new ObjetDuplicator("Email UNIQUE");
            }
        }

//        Course course = teacher.getCourse();
//        courseRespository
//                .findById(course.getId())
//                .orElseThrow(()->new ObjectNotFoundException("Course not found"));
        return teacherRepository.save(teacher);
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
