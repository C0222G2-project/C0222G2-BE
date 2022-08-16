package com.coffee.controller;

import com.coffee.model.jwt.JwtRequest;
import com.coffee.service.jwt.JwtUserDetailsService;
import com.coffee.util.JwtTokenUtil;
import com.coffee.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class LogoutController {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    /**
     * @author: PhuongTD
     * @date-create 15/8/2022
     * @param jwtRequestBody
     * @return
     */
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/logoutSecurity")
    public ResponseEntity<?> logoutSecurity(@RequestBody Optional<JwtRequest> jwtRequestBody) {
        JwtRequest jwtRequest = jwtRequestBody.orElse(new JwtRequest());

        if (jwtRequest.getToken().equals("")) {
            return new ResponseEntity<>("isLogout", HttpStatus.UNAUTHORIZED);
        }
        if (this.tokenUtil.getTokenMap().isEmpty()) {
            return new ResponseEntity<>("LoginExpired", HttpStatus.UNAUTHORIZED);
        }
        if (this.tokenUtil.getTokenMap()
                .get(this.jwtTokenUtil.getUsernameFromToken(jwtRequest.getToken())).equals(jwtRequest.getToken())) {
            this.tokenUtil.getTokenMap().remove(this.jwtTokenUtil.getUsernameFromToken(jwtRequest.getToken()));
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
