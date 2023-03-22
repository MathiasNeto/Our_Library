package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
