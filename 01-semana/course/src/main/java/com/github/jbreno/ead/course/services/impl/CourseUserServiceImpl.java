package com.github.jbreno.ead.course.services.impl;

import com.github.jbreno.ead.course.models.CourseModel;
import com.github.jbreno.ead.course.models.CourseUserModel;
import com.github.jbreno.ead.course.repositories.CourseUserRepository;
import com.github.jbreno.ead.course.services.CourseService;
import com.github.jbreno.ead.course.services.CourseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CourseUserServiceImpl implements CourseUserService {

    @Autowired
    private CourseUserRepository courseUserRepository;

    @Override
    public boolean existsByCourseAndUserId(CourseModel courseModel, UUID userId) {
        return courseUserRepository.existsByCourseAndUserId(courseModel, userId);
    }

    @Override
    public CourseUserModel save(CourseUserModel courseUserModel) {
        return courseUserRepository.save(courseUserModel);
    }
}
