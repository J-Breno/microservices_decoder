package com.github.jbreno.ead.authuser.services.impl;

import com.github.jbreno.ead.authuser.repositories.UserRepository;
import com.github.jbreno.ead.authuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
}
