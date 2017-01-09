package org.coderearth.securedrest.jwtsecurity.model.response;

/**
 * Created by kunal_patel on 1/6/17.
 */
public class AuthResponse {
    private String token;

    public AuthResponse() {
    }

    public AuthResponse(final String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }
}
