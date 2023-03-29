package com.ourlibrary.project_library.Controllers;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Contact;
import com.ourlibrary.project_library.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping
    public ResponseEntity<Contact> insert(@RequestBody Contact contact){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(contact));
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Contact>> findAll(){
        List<Contact> contactList = service.findAll();
        return ResponseEntity.ok(contactList);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Contact> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
