package edu.fbansept.estiam25cidc.controller;

import edu.fbansept.estiam25cidc.model.AppUser;
import edu.fbansept.estiam25cidc.service.IJwtService;
import edu.fbansept.estiam25cidc.service.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    protected IJwtService jwtService;

    @Autowired
    public AuthController(IJwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Map<String, Object>> signIn(
            @RequestBody AppUser appUser) {

        return ResponseEntity.ok(Map.of(
                "jwt", jwtService.generateToken(appUser.getEmail())
        ));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<AppUser> signUp(
            @RequestBody AppUser appUser
    ) {
        return new ResponseEntity<>(appUser, HttpStatus.CREATED);
    }

}
