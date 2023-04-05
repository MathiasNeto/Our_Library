package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.UserDTO;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Teacher;
import com.ourlibrary.project_library.repositories.TeacherRepository;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository repository;
    public Teacher insert(Teacher teacher){
        return repository.save(teacher);
    }
//    public List<UserDTO> findAll (){
//        List<Teacher> list = repository.findAll();
//        return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
//    }
    //Adicionar o construtor la em userdto para teatcher e descomentar.

    public Teacher findById( Long id) {
        return repository.findById(id).orElseThrow(()->new ObjectNotFoundException("Entity not found"));
    }
}
