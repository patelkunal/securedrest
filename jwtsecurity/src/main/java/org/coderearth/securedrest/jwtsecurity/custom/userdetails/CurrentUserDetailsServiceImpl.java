package org.coderearth.securedrest.jwtsecurity.custom.userdetails;

import org.coderearth.securedrest.core.model.AppUser;
import org.coderearth.securedrest.core.repository.AppUserRepository;
import org.coderearth.securedrest.jwtsecurity.model.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Custom user-details service along with some business logic.
 * <p>
 * Created by kunal_patel on 1/21/17.
 */
@Component("currentUserDetailsServiceImpl")
@Primary
public class CurrentUserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public CurrentUserDetailsServiceImpl(final AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final AppUser appUser = appUserRepository.findByUsername(username);
        return new CurrentUser(appUser);
    }

}
