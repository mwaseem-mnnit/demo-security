package com.example.demosecurity.service;

import com.example.demosecurity.dto.UserDTO;
import com.example.demosecurity.entity.Authority;
import com.example.demosecurity.entity.User;
import com.example.demosecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mohd.waseem on 28/06/20.
 */
@Service
public class UserDetailServiceH2 implements UserDetailsService {
    private static final String DEFAULT_ROLE = "USER";
    private final UserRepository repository;
    private PasswordEncoder encoder;

    public UserDetailServiceH2(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = repository.findByUserName(userName);
        if(user == null) throw new UsernameNotFoundException(userName);
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .roles(user.getAuthorities().stream().map(Authority::getAuthority).toArray(String[]::new))
                .build();
    }

    @Transactional
    public void createUser(UserDTO userDTO) throws Exception {
        User user = User.builder()
                .userName(userDTO.getUserName())
                .email(userDTO.getEmail())
                .password(encoder.encode(userDTO.getPassword()))
                .enabled(Boolean.TRUE)
                .build();
        user.addAuthority(Authority.builder()
                .authority(DEFAULT_ROLE)
                .user(user)
                .build());
        try{
            repository.save(user);
        } catch (Exception ex) {
            throw new Exception("error while saving");
        }
    }
}
