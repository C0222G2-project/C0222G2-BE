package com.coffee.controller.simple_email;

import com.coffee.model.account.AppUser;
import com.coffee.model.jwt.JwtRequest;
import com.coffee.model.jwt.JwtResponse;
import com.coffee.service.account.IAppUserService;
import com.coffee.util.EncrytedPasswordUtils;
import com.coffee.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin
public class SimpleEmailController {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private EncrytedPasswordUtils encrytedPasswordUtils;

    @Value("${spring.mail.username}")
    private String myEmail;

    private List<String> tokenList;

    /**
     * @param jwtRequest
     * @return
     * @creator: PhuongTD
     * @date-create 9/8/2022
     */
    @PostMapping("/sendSimpleEmail")
    public ResponseEntity<?> sendSimpleEmail(@RequestBody JwtRequest jwtRequest) {
        if (jwtRequest.getUsername() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AppUser appUser = this.appUserService.findAppUserByUsername(jwtRequest.getUsername());
        if (appUser != null) {
            // Create a Simple MailMessage.
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(this.myEmail);
            message.setTo(appUser.getEmployee().getEmail());
            message.setSubject("Find password");
            String token = jwtTokenUtil.generateToken(jwtRequest.getUsername());
            this.tokenList.add(token);
            message.setText("http://localhost:8080/forgotPassword/" + token);

            // Send Message!
            this.emailSender.send(message);
            return ResponseEntity.ok(new JwtResponse(token));
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * @param token
     * @param response
     * @return redirect to change password form if true or redirect to login form if false
     * @throws IOException
     * @creator: PhuongTD
     * @date-create 9/8/2022
     */
    @GetMapping("/forgotPassword/{token}")
    public ResponseEntity<?> getUsernameForChangePassword(@PathVariable String token, HttpServletResponse response) throws IOException {
        if (this.tokenList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        for (String tokenVal: this.tokenList) {
            if (tokenVal.equals(token)) {
                response.sendRedirect("http://localhost:4200/forgot/" + token);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        response.sendRedirect("http://localhost:4200/login");
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Method change password
     *
     * @param jwtRequest
     * @return status 401 if token null
     * @creator: PhuongTD
     * @date-create 9/8/2022
     */
    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@Valid @RequestBody JwtRequest jwtRequest, BindingResult bindingResult) {
        if (this.tokenList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        for (String tokenVal: this.tokenList) {
            if (tokenVal.equals(jwtRequest.getToken())) {
                AppUser appUser = this.appUserService.findAppUserByUsername(jwtTokenUtil.getUsernameFromToken(jwtRequest.getToken()));
                if (appUser != null) {
                    if (bindingResult.hasErrors()) {
                        return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
                    }
                    if (jwtRequest.getPassword().equals(jwtRequest.getConfirmPassword())) {
                        appUser.setPassword(encrytedPasswordUtils.encrytePassword(jwtRequest.getPassword()));
                        Date date = new Date(System.currentTimeMillis());
                        appUser.setCreationDate(date);
                        this.appUserService.updatePassword(appUser);
                        this.tokenList.remove(jwtRequest.getToken());
                        return new ResponseEntity<>(HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>("Password Not Same", HttpStatus.OK);
                    }
                } else {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
