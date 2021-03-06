package org.coderearth.securedrest.jwtsecurity.controller;

import org.coderearth.securedrest.jwtsecurity.common.TokenUtils;
import org.coderearth.securedrest.jwtsecurity.model.request.LoginCredential;
import org.coderearth.securedrest.jwtsecurity.model.response.AuthResponse;
import org.coderearth.securedrest.jwtsecurity.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kunal_patel on 12/30/16.
 */
@RestController
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager manager;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    protected ResponseEntity<AuthResponse> doLogin(@RequestBody LoginCredential credential) {
        LOGGER.debug("auth request from username = {}", credential.getUsername());
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(credential.getUsername(), credential.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String validUserName = loginService.isValidUser(credential);
        String token = tokenUtils.generateToken(validUserName);
        LOGGER.debug("token generated for username = {}", credential.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

}
