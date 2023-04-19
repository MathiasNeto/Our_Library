package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Boolean existsByCpf(String cpf);
}
