package ua.lviv.lgs.money.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtils {

    private SecurityUtils() {

    }

    public static String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();

    }

}
