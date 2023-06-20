package com.auth.securityplayground.filters;

import jakarta.servlet.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.logging.Logger;


@Log4j2
public class AuthoritiesLoggingAfterFilter implements Filter {

    private final Logger LOG = Logger.getLogger(AuthoritiesLoggingAfterFilter.class.getName());
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // get authenticated user from context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            log.info("User " + authentication.getName() + " is successfully authenticated and "
                    + "has the authorities " + authentication.getAuthorities().toString());
        }

        chain.doFilter(request, response);
    }
}
