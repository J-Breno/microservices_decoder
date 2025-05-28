package com.github.jbreno.ead.authuser.repositories;

import com.github.jbreno.ead.authuser.models.UserCourseModel;
import com.github.jbreno.ead.authuser.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserCourseRepository extends JpaRepository<UserCourseModel, UUID> {
    boolean existsByUserAndCourseId(UserModel user, UUID courseId);
}
