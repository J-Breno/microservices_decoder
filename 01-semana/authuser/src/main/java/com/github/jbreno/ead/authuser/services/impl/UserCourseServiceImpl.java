package com.github.jbreno.ead.authuser.services.impl;

import com.github.jbreno.ead.authuser.models.UserCourseModel;
import com.github.jbreno.ead.authuser.models.UserModel;
import com.github.jbreno.ead.authuser.repositories.UserCourseRepository;
import com.github.jbreno.ead.authuser.services.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Override
    public boolean existsByUserAndCourseId(UserModel userModel, UUID courseId) {
        return userCourseRepository.existsByUserAndCourseId(userModel, courseId);
    }

    @Override
    public UserCourseModel save(UserCourseModel userCourseModel) {
        return userCourseRepository.save(userCourseModel);
    }
}
