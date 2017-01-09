package org.coderearth.securedrest.jwtsecurity.service;

import com.google.common.collect.Lists;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunal_patel on 12/30/16.
 */
@Component
public class InMemoryUserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsManager userDetailsManager;

    public InMemoryUserDetailsServiceImpl() {
        List<UserDetails> users = new ArrayList<>(2);
        users.add(new User("admin", "s3cr3t", Lists.newArrayList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
        users.add(new User("user", "password", Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER"))));
        userDetailsManager = new InMemoryUserDetailsManager(users);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserDetails user = userDetailsManager.loadUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        else
            return user;
    }
}
