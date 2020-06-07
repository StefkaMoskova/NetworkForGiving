package org.talentboost.networkforgiving.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUtil {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public boolean isAuthenticated(HttpServletRequest request) {
        String requestTokenHeader = request.getHeader("Authorization");
        String jwtToken = null;

        // jwtToken is in the form "Bearer token"
        // Remove Bearer word and get only the token
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
        }

        return jwtToken != null && jwtTokenUtil.validateToken(jwtToken);
    }
}