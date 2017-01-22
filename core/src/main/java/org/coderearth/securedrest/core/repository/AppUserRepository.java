package org.coderearth.securedrest.core.repository;

import org.coderearth.securedrest.core.model.AppUser;

/**
 * Created by kunal_patel on 1/21/17.
 */
public interface AppUserRepository {

    AppUser findByUsername(final String username);

}
