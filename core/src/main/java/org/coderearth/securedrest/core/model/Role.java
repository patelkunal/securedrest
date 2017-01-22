package org.coderearth.securedrest.core.model;

import java.util.stream.Stream;

/**
 * Created by kunal_patel on 1/21/17.
 */
public enum Role {
    ROLE_ADMIN("admin"), ROLE_USER("user");

    private final String roleName;

    Role(final String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public static Role forValue(final String aRoleName) {
        return Stream.of(Role.values())
                .filter(role -> role.getRoleName().equalsIgnoreCase(aRoleName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown role, RoleName = " + aRoleName));
    }
}
