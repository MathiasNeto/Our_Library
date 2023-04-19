package com.ourlibrary.project_library.repositories;

import com.ourlibrary.project_library.entities.Course;
import com.ourlibrary.project_library.enuns.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {
    Optional<Course> findByAreaAndName(Area area, String name);

}
