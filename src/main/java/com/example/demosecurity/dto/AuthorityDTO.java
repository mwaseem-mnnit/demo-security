package com.example.demosecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by mohd.waseem on 28/06/20.
 */
@Data
@Builder
@AllArgsConstructor
public class AuthorityDTO {
    private String role;
    private String userName;
}
