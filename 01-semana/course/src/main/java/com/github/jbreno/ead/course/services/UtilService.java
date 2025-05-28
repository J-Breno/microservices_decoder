package com.github.jbreno.ead.course.services;

import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UtilService {
    public String createUrlGetAllUsersByCourse(UUID courseId, Pageable pageable);

}
