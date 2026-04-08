package fr.nirahtech.limayrac.ecommerce;

import java.io.IOException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiTokenFilter.class);

    private static final String API_TOKEN_HEADER_NAME = "API-Token";

    @Override
    protected void doFilterInternal(
        HttpServletRequest request, 
        HttpServletResponse response, 
        FilterChain filterChain)
        throws ServletException, IOException {
            LOGGER.info("ApiTokenFilter");

            
            
            if (Objects.isNull(request.getHeader(API_TOKEN_HEADER_NAME))) {
                // throw new MissingApiTokenException("Missing API token in header !...");
            }

            filterChain.doFilter(request, response);
    }
}
