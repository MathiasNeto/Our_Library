package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.StudentDTO;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.repositories.StudentRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student insert(Student student){
        return studentRepository.save(student);
    }
    public List<StudentDTO> findAll (){
        List<Student> list = studentRepository.findAll();
        return list.stream().map(x -> new StudentDTO(x)).collect(Collectors.toList());
    }
}