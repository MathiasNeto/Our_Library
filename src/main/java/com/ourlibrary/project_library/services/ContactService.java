package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Contact;
import com.ourlibrary.project_library.entities.Course;
import com.ourlibrary.project_library.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public Contact insert(Contact contact){
        return repository.save(contact);
    }

    public List<Contact> findAll() {
        return repository.findAll();
    }

    public Contact findById(Long id) {
        return repository.findById(id).get();
    }
}
