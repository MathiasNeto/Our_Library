package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.LibrarianDTO;
import com.ourlibrary.project_library.services.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.services.Excetions.ObjetDuplicator;
import com.ourlibrary.project_library.entities.Librarian;
import com.ourlibrary.project_library.repositories.ContactRepository;
import com.ourlibrary.project_library.repositories.LibrarianRepository;
import com.ourlibrary.project_library.repositories.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;
    private final ContactRepository contactRepository;
    private final LoginRepository loginRepository;

    public LibrarianDTO insert(Librarian librarian){
        if(librarianRepository.existsByCpf(librarian.getCpf())){
            throw new ObjetDuplicator("CPF UNIQUE");
        }
        for (int i = 0; i < librarian.getContactList().size(); i++) {
            if (contactRepository.
                    existsByEmail(librarian.getContactList().get(i).getEmail())){
                throw new ObjetDuplicator("Email UNIQUE");
            }
        }
        if(loginRepository.existsByRegistration(librarian.getLogin().getRegistration())){
            throw new ObjetDuplicator("Registration UNIQUE");
        }
        librarian.getContactList().get(0).setUser(librarian);
        librarianRepository.save(librarian);
        return new LibrarianDTO(librarian);
    }
    public Librarian getById(Long id){
        return librarianRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id not found"));
    }
}
