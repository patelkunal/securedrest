package org.coderearth.securedrest.jwtsecurity.model;

import org.coderearth.securedrest.core.model.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by kunal_patel on 1/21/17.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private AppUser appUser;

    public CurrentUser(final AppUser appUser) {
        super(appUser.getUsername(),
                appUser.getPassword(),
                appUser.getRoles()
                        .parallelStream()
                        .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                        .collect(Collectors.toSet())
        );
        this.appUser = appUser;
    }

    public CurrentUser(final String username, final String password, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CurrentUser(final String username, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired, final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public AppUser getAppUser() {
        return appUser;
    }
}
