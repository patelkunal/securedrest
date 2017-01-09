package org.coderkitchen.securedrest.service;

import org.coderkitchen.securedrest.security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kunal_patel on 12/30/16.
 */
@Service
public class TokenService {
    @Autowired
    private TokenUtils tokenUtils;

    public String createToken(final String validUserName) {
        return tokenUtils.generateToken(validUserName);
    }
}
