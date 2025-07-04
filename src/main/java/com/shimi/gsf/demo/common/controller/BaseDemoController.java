package com.shimi.gsf.demo.common.controller;

import com.shimi.gsf.demo.user.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseDemoController {
    /**
     * Get the current authenticated user.
     * @return the current authenticated user, or null if no user is authenticated.
     */
    protected User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.getPrincipal() instanceof User) {
            return (User) auth.getPrincipal();
        } else {
            return null;
        }
    }
}
