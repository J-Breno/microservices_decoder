package com.github.jbreno.ead.authuser.services.impl;

import com.github.jbreno.ead.authuser.services.UtilsService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtilServiceImpl implements UtilsService {

    public String createUrlGetAllUsersByCourse(UUID userId, Pageable pageable) {
      return "/courses?userId" + userId + "&page=" + pageable.getPageNumber() + "&size=" + pageable.getPageSize()
                + "&sort=" + pageable.getSort().toString().replaceAll(": ", "m");
    }
}
