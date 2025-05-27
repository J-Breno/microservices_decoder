package com.github.jbreno.ead.authuser.services.impl;

import com.github.jbreno.ead.authuser.repositories.UserCourseRepository;
import com.github.jbreno.ead.authuser.services.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;
}
