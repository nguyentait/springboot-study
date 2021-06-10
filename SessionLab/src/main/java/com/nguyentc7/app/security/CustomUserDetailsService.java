package com.nguyentc7.app.security;

import com.nguyentc7.app.entity.User;
import com.nguyentc7.app.exception.items.NotFoundException;
import com.nguyentc7.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user != null){
            return new CustomUserDetails(user);
        }else{
            throw new NotFoundException("Can not find User name");
        }

    }
}
