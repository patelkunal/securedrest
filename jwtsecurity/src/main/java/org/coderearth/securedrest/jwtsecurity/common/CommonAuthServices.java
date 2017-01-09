package org.coderearth.securedrest.jwtsecurity.common;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * Created by kunal_patel on 1/2/17.
 */
@Component
public class CommonAuthServices {

    public User getUserFromSession() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) throw new AccessDeniedException("Unauthorized Access");
        if (!(auth.getPrincipal() instanceof User))
            throw new AccessDeniedException("Unauthorized Access, invalid user");
        return (User) auth.getPrincipal();
    }

    public String getUsernameFromSession() {
        User user = this.getUserFromSession();
        return user.getUsername() == null ? null : user.getUsername();
    }

}
