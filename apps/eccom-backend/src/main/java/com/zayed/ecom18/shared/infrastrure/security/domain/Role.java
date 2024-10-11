package com.zayed.ecom18.shared.infrastrure.security.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.zayed.ecom18.shared.infrastrure.security.error.domain.Assert;

public enum Role {
    ADMIN,
    USER,
    ANONYMOUS,
    UNKNOWN;
    
    
    private final static String ROLE_PREFIX = "ROLE_";
    private static final Map<String,Role> Roles = buildRoles();
    
    private static Map<String,Role> buildRoles() {

            return Stream.of(values()).collect(Collectors.toUnmodifiableMap(Role::key, Function.identity()));
    }

    public String key() {
        return ROLE_PREFIX + name();
    }
    public static Role from(String role) {
        Assert.notBlank("role", role);
    
        return Roles    .getOrDefault(role, UNKNOWN);
      }
}
