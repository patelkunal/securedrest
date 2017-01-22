package org.coderearth.securedrest.core.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by kunal_patel on 1/21/17.
 */
public class AppUser {

    private String username;
    private String password;
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(final List<Role> roles) {
        this.roles = roles;
    }

    public Set<String> getRoleStrings() {
        return getRoles()
                .parallelStream()
                .map(role -> role.getRoleName())
                .collect(Collectors.toSet());
    }
}
