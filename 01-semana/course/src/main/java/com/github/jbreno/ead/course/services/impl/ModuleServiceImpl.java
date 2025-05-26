package com.github.jbreno.ead.course.services.impl;

import com.github.jbreno.ead.course.repositories.ModuleRepository;
import com.github.jbreno.ead.course.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;
}
