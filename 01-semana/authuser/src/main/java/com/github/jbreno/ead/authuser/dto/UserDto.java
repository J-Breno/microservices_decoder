package com.github.jbreno.ead.authuser.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.jbreno.ead.authuser.enums.UserStatus;
import com.github.jbreno.ead.authuser.enums.UserType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private UUID userId;
    private String username;
    private String password;
    private String email;
    private String oldPassword;
    private String fullName;
    private String phoneNumber;
    private String cpf;
    private String imgUrl;
}
