package com.github.jbreno.ead.authuser.services;

import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UtilsService {
    public String createUrlGetAllUsersByCourse(UUID userId, Pageable pageable);
}
