package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    Boolean existsByEmail(String email);
}
