package hu.flowacademy.first.time.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

@Configuration
public class CustomUserDetailService implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (invalidUsername(username)) {
            throw new UsernameNotFoundException("");
        }
        return new User(username,
                "", true, true,
                true, true,
                Arrays.asList(new SimpleGrantedAuthority("user")));
    }

    private boolean invalidUsername(String username) {
        return false;
    }

}
