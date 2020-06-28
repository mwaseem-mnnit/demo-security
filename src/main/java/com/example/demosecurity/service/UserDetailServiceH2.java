package com.example.demosecurity.service;

import com.example.demosecurity.entity.Authorities;
import com.example.demosecurity.entity.User;
import com.example.demosecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mohd.waseem on 28/06/20.
 */
@Service
public class UserDetailServiceH2 implements UserDetailsService {
    private final UserRepository repository;

    public UserDetailServiceH2(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = repository.findByUserName(userName);
        if(user == null) throw new UsernameNotFoundException(userName);
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .roles(user.getAuthorities().stream().map(Authorities::getAuthority).toArray(String[]::new))
                .build();
    }
}
