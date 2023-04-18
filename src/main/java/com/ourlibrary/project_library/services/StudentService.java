package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.StudentDTO;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Excetions.ObjetDuplicator;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.repositories.ContactRepository;
import com.ourlibrary.project_library.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ContactRepository contactRepository;
    public StudentDTO insert(Student student) {
        for (int i = 0; i < student.getContactList().size(); i++) {
            student.getContactList().get(i).setUser(student);

            if (contactRepository.existsByEmail(student.getContactList().get(i).getEmail())) {
                throw new ObjetDuplicator("Email UNIQUE");
            }
        }
        if (studentRepository.existsByCpf(student.getCpf())) {
            throw new ObjetDuplicator("CPF Duplicator " + student.getCpf());
        }

        StudentDTO dto = new StudentDTO();
        dto.setArea(String.valueOf(student.getCourse().getArea()));
        dto.setName(student.getName_user());
        dto.setCity(student.getAddress().getCity());
        dto.setUf(student.getAddress().getUf());
        for (int i = 0; i < student.getContactList().size(); i++) {
            dto.setGmail(student.getContactList().get(i).getEmail());
            dto.setTelephone(student.getContactList().get(i).getTelephone());
        }
        dto.setGender(student.getEnumGender());
        dto.setRoad(student.getAddress().getRoad());
        dto.setNeighborhood(student.getAddress().getNeighborhood());
        dto.setName_Course(student.getCourse().getName_Course());
        dto.setPeriod_Course(student.getPeriod_course());
        dto.setNumber(student.getAddress().getNumber());
        student.setCourse(student.getCourse());
        studentRepository.save(student);
        return dto;
    }

    public List<StudentDTO> findAll() {
        List<Student> list = studentRepository.findAll();
        return list.stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id not found"));
    }
}