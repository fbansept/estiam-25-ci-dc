package edu.fbansept.estiam25cidc.unitaire;

import edu.fbansept.estiam25cidc.controller.AuthController;
import edu.fbansept.estiam25cidc.mock.MockJwtService;
import edu.fbansept.estiam25cidc.model.AppUser;
import edu.fbansept.estiam25cidc.service.JwtService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JwtServiceTests {

    JwtService jwtService;

    @BeforeEach
    public void init() {
        jwtService = new JwtService();
        //simule l'affectation de valeur par l'annotation @Value pour notre test
        ReflectionTestUtils.setField(jwtService, "secret", "azerty123");
    }

    @Test
    public void testGenerateTokenWithUser_shouldReturnToken() {

        String jwt = jwtService.generateToken("a@a.com");

        Assertions.assertEquals(
                "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhQGEuY29tIn0.9t1ocuqEU3o2ROATDyK_jSBn6AxOORn7cyZxJVxoQ60",
                jwt);
    }


}
