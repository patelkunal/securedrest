package org.coderearth.securedrest.jwtsecurity.custom;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Since we are not doing any fency thing in AuthEntryPoint here, just use
 * <code>Http403ForbiddenEntryPoint</code>
 * <p>
 * Created by kunal_patel on 12/30/16.
 */
@Deprecated
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
