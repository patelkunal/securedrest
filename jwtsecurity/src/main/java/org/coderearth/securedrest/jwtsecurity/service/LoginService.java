package org.coderearth.securedrest.jwtsecurity.service;

import org.coderearth.securedrest.jwtsecurity.model.request.LoginCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by kunal_patel on 12/30/16.
 */
@Service
public class LoginService {

    @Autowired
    private UserDetailsService service;

    public String isValidUser(final LoginCredential credential) {
        UserDetails userDetails = service.loadUserByUsername(credential.getUsername());
        return userDetails != null ? userDetails.getUsername() : null;
    }
}
