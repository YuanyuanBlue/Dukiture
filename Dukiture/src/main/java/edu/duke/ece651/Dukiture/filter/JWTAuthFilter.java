package edu.duke.ece651.Dukiture.filter;

import edu.duke.ece651.Dukiture.util.JWTConstants;
import edu.duke.ece651.Dukiture.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = httpServletRequest.getHeader(JWTConstants.HEADER_PREFIX);
        String username = null;
        logger.info(header);
        if (header == null  ||  !header.startsWith("Bearer ")) {
            logger.error("No header found in request.");
        } else {
            header = header.substring(7);
            logger.info(header);
            try {
                username = jwtUtil.getUsernamefromToken(header);
            } catch (Exception e) {
                logger.error("error when trying to use token to retrieve username.");
                httpServletResponse.sendError(404, "An error occurred when trying to revolve this request.");
                return;
            }
            logger.info(username);
            if (username != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (jwtUtil.isValid(header, userDetails)) {
                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(userDetails, null,
                                    new ArrayList<>(userDetails.getAuthorities()));
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    logger.info("API Token authenticated!");
                } else {
                    logger.error("API Token authentication failed!");
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}

