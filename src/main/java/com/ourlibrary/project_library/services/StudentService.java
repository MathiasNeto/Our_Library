package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.UserDTO;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student insert(Student student){
        return studentRepository.save(student);
    }
    public List<UserDTO> findAll (){
        List<Student> list = studentRepository.findAll();
        return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }
}