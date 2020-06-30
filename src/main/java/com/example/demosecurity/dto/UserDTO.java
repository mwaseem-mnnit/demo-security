package com.example.demosecurity.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by mohd.waseem on 28/06/20.
 */
@Data
public class UserDTO {

    @NotNull(message = "First name cannot be null")
    private String firstName;
    private String lastName;
    private String userName;
    @Email
    private String email;
    private String password;
    private String confirmPassword;
    private Boolean enabled;
    private List<AuthorityDTO> authoritiesDTO;
}