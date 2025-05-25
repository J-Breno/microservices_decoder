package com.github.jbreno.ead.authuser.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
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

    public interface UserView {
        public static interface RegistrationPost {}
        public static interface UserPut {}
        public static interface PasswordPut {}
        public static interface ImagePut {}
    }

    private UUID userId;
    @JsonView(UserView.RegistrationPost.class)
    private String username;

    @JsonView({UserView.PasswordPut.class, UserView.RegistrationPost.class})
    private String password;

    @JsonView(UserView.RegistrationPost.class)
    private String email;
    @JsonView({ UserView.RegistrationPost.class})
    private String oldPassword;
    @JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
    private String fullName;
    @JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
    private String phoneNumber;
    @JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
    private String cpf;
    @JsonView({UserView.ImagePut.class})
    private String imgUrl;
}
