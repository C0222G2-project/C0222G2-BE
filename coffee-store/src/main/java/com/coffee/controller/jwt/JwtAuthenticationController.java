package com.coffee.controller.jwt;

import com.coffee.model.account.AppUser;
import com.coffee.model.jwt.JwtRequest;
import com.coffee.model.jwt.JwtResponse;
import com.coffee.service.account.IAppUserService;
import com.coffee.service.account.impl.AppUserService;
import com.coffee.service.jwt.JwtUserDetailsService;
import com.coffee.util.JwtTokenUtil;
import com.coffee.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private TokenUtil tokenUtil;

    /**
     * @param authenticationRequest
     * @return token, roles list, username, status 200 if AUTHORIZED or return status 401 if UNAUTHORIZED
     * @throws Exception
     * @creator: PhuongTD
     * @date-create 9/8/2022
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        if (authenticationRequest.getUsername() == null || authenticationRequest.getPassword() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        if (userDetails == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        AppUser appUser = this.appUserService.findAppUserByUsername(authenticationRequest.getUsername());
        Date date = new Date(System.currentTimeMillis());

        if (date.toLocalDate().compareTo(appUser.getCreationDate().toLocalDate().plusDays(30)) >= 0) {
            return new ResponseEntity<>("PasswordExpired", HttpStatus.UNAUTHORIZED);
        }

        List<String> grantList = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        final String token = jwtTokenUtil.generateToken(userDetails);

        this.tokenUtil.getTokenMap().put(userDetails.getUsername(), token);

        return ResponseEntity.ok(new JwtResponse(token, grantList, userDetails.getUsername()));
    }

    /**
     * @param username
     * @param password
     * @throws Exception
     * @creator: PhuongTD
     * @date-create 9/8/2022
     */
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
