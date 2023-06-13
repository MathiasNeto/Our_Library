package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Login;
import com.ourlibrary.project_library.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Boolean existsByRegistration(String s);


    @Query("SELECT u FROM Users u WHERE u.login.email =:email AND u.login.password =:password")
    Optional<Users> findByUser(String email, String password);
}
