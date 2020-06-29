package com.example.demosecurity.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by mohd.waseem on 28/06/20.
 */
@Data
public class UserDTO {
    private String userName;
    private String password;
    private String email;
    private Boolean enabled;
    private List<AuthorityDTO> authoritiesDTO;
}