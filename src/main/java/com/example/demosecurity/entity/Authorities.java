package com.example.demosecurity.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mohd.waseem on 28/06/20.
 */
@Entity
@Table(name = "authorities")
@Data
public class Authorities {

    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "authority")
    private String authority;
}
