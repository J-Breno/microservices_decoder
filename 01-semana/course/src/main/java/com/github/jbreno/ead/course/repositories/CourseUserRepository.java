package com.github.jbreno.ead.course.repositories;

import com.github.jbreno.ead.course.models.CourseModel;
import com.github.jbreno.ead.course.models.CourseUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseUserRepository extends JpaRepository<CourseUserModel, UUID> {
    boolean existsByCourseAndUserId(CourseModel course, UUID userId);
}
