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

public class AuthControllerTests {

    protected AuthController controller;

    @BeforeEach
    public void init() {

        controller = new AuthController(new MockJwtService());

    }

    @Test
    public void testSignInWithValidUser_shouldReturnJwt() {

        ResponseEntity<Map<String, Object>> reponse =
                controller.signIn(new AppUser("a@a.com","root"));

        Assertions.assertTrue(reponse.getBody().containsKey("jwt"));
    }

    @Test
    public void testSignInWithValidUser_shouldReturnOk() {

        ResponseEntity<Map<String, Object>> reponse =
                controller.signIn(new AppUser("a@a.com","root"));

        assertEquals(HttpStatus.OK, reponse.getStatusCode());
    }

}
