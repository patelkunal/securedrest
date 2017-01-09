package org.coderkitchen.securedrest.model.request;

import com.google.common.base.MoreObjects;

/**
 * Created by kunal_patel on 12/30/16.
 */
public class LoginCredential {

    private String username;
    private String password;

    public LoginCredential() {
    }

    public LoginCredential(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("username", username)
                .toString();
    }
}
