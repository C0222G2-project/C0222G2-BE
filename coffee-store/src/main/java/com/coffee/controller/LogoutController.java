package com.coffee.controller;

import com.coffee.model.jwt.JwtRequest;
import com.coffee.util.JwtTokenUtil;
import com.coffee.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class LogoutController {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ResponseBody
    @PostMapping("/logoutSecurity")
    public ResponseEntity<?> logoutSecurity(@RequestBody Optional<JwtRequest> jwtRequestBody) {
        JwtRequest jwtRequest = jwtRequestBody.orElse(new JwtRequest());
        if (jwtRequest.getToken().equals("")) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
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
