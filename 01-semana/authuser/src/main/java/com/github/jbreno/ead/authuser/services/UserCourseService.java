package com.github.jbreno.ead.authuser.services;

import com.github.jbreno.ead.authuser.models.UserCourseModel;
import com.github.jbreno.ead.authuser.models.UserModel;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface UserCourseService {
    boolean existsByUserAndCourseId(UserModel userModel, UUID courseId);

    UserCourseModel save(UserCourseModel userCourseModel);
}
