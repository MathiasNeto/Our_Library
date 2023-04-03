package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Contact;
import com.ourlibrary.project_library.entities.Devolution;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.repositories.DevolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DevolutionService {

    private final DevolutionRepository devolutionRepository;

    public Devolution insert(Devolution devolution){
        return devolutionRepository.save(devolution);
    }

    public List<Devolution> findAll() {
        return devolutionRepository.findAll();
    }

    public Devolution findById( Long id) {
        return devolutionRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Id not found"));
    }
//    public void delete(Long id){
//        if(devolutionRepository.findById(id).isPresent()){
//            devolutionRepository.deleteById(id);
//        }else{
//            throw new ObjectNotFoundException("Id not found");
//        }
//
//    }
}