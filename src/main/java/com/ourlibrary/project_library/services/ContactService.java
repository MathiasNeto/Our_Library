package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Contact;
import com.ourlibrary.project_library.services.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public Contact insert(Contact contact){
        return contactRepository.save(contact);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Id not found"));
    }
    public void delete(Long id){
        if(contactRepository.findById(id).isPresent()){
            contactRepository.deleteById(id);
        }else{
            throw new ObjectNotFoundException("Id not found");
        }
    }
    public Contact contactUpdate( Contact contact){
        contactRepository.findById(contact.getId())
                .orElseThrow(()->new ObjectNotFoundException("Contact not found"));
        contact.setEmail(contact.getEmail());
        contact.setTelephone(contact.getTelephone());
        return contactRepository.save(contact);
    }
}
