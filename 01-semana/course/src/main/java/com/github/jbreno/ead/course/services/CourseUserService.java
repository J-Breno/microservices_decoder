package com.github.jbreno.ead.course.services;

import com.github.jbreno.ead.course.models.CourseModel;
import com.github.jbreno.ead.course.models.CourseUserModel;

import java.util.UUID;

public interface CourseUserService {
    boolean existsByCourseAndUserId(CourseModel courseModel, UUID userId);

    CourseUserModel save(CourseUserModel courseUserModel);
}
