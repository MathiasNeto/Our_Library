package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Boolean existsByRegistration(String s);
}
