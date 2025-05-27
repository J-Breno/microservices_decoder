package com.github.jbreno.ead.course.services.impl;

import com.github.jbreno.ead.course.services.CourseService;
import com.github.jbreno.ead.course.services.CourseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseUserServiceImpl implements CourseUserService {

    @Autowired
    private CourseService courseService;
}
