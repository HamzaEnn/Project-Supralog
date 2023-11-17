package com.example.RegistrationService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.RegistrationService.controllers.RegistrationController;
import com.example.RegistrationService.model.RegistrationRequest;
import com.example.RegistrationService.repository.UserRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationControllerTest {

    @Autowired
    private RegistrationController registrationController;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testRegistrationSuccess() throws Exception {
        // Mock registration request
        RegistrationRequest request = new RegistrationRequest("John cena", "johncena", "johncena@example.com", "password", "France", "Paris", 25, "1234567890", "SMT Inc", "Male");

        // Mock user not existing
        when(userRepository.existsByUsername(anyString())).thenReturn(false);
        when(userRepository.existsByEmail(anyString())).thenReturn(false);

        // Perform registration
        ResponseEntity<?> response = registrationController.register(request);

        // Assert registration success
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assert(response.getBody().toString().contains("User registered successfuly"));
    }

    @Test
    public void testRegistrationFailure() {
        // Mock registration request with missing mandatory parameters
        RegistrationRequest request = new RegistrationRequest("", "joker", "joker@example.com", "password", "France", "Paris", 17, "1234567890", "ABC", "Male");

        // Perform registration
        ResponseEntity<?> response = registrationController.register(request);

        // Assert registration failure
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assert(response.getBody().toString().contains("Name is required"));
    }

    @Test
    public void testRegistrationFailureMatched() {
        // Mock registration request with missing mandatory parameters
        RegistrationRequest request = new RegistrationRequest("cena", "johncena", "johncena2@example.com", "password", "France", "Paris", 23, "1234567890", "ABCD", "Male");

        // Mock user not existing
        when(userRepository.existsByUsername(anyString())).thenReturn(true);
        when(userRepository.existsByEmail(anyString())).thenReturn(false);

        // Perform registration
        ResponseEntity<?> response = registrationController.register(request);

        // Assert registration failureZZ
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assert(response.getBody().toString().contains("An account is already registered by this username"));
    }

}