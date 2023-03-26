package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Course;
import com.ourlibrary.project_library.entities.Devolution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRespository extends JpaRepository<Course,Long> {
}
