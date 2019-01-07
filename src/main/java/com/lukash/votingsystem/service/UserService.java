package com.lukash.votingsystem.service;

import com.lukash.votingsystem.CustomUser;
import com.lukash.votingsystem.exception.NotFoundException;
import com.lukash.votingsystem.model.Role;
import com.lukash.votingsystem.model.User;
import com.lukash.votingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByEmail(final String email) {
        return userRepository.findByEmail(email).orElseThrow(NotFoundException::new);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        User authUser = getByEmail(email);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : authUser.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.name()));
        }
        return new CustomUser(authUser.getEmail(), authUser.getPassword(), grantedAuthorities, authUser.getId());
    }
}
