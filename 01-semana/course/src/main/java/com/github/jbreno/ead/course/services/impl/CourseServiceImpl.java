package com.github.jbreno.ead.course.services.impl;

import com.github.jbreno.ead.course.repositories.CourseRepository;
import com.github.jbreno.ead.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
}
