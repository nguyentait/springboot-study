package com.nguyentc7.app.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (userName.equals("whoami")) {
            //load user from db
            String password = new BCryptPasswordEncoder().encode("123456");
            return User.withUsername("whoami").password(password).roles("USER").build();
        } else {
            throw new UsernameNotFoundException(userName + " does not exist");
        }
    }
}
