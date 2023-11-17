package com.example.RegistrationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.RegistrationService.model.ErrorMessage;
import com.example.RegistrationService.model.RegistrationRequest;

public class RegistrationRequestTest {

    @Test
    public void testCheckRequestValid() {
        // Create a valid registration request
        RegistrationRequest request = new RegistrationRequest("John Doe", "johndoe", "johndoe@example.com", "password", "France", "Paris", 25, "1234567890", "ABC Inc", "Male");

        // Perform checkRequest
        ErrorMessage result = request.checkRequest();

        // Assert that the result is NO_ERROR
        assertEquals(ErrorMessage.NO_ERROR, result);
    }

    @Test
    public void testCheckRequestInvalid() {
        // Create an invalid registration request with missing mandatory parameters
        RegistrationRequest request = new RegistrationRequest("", "johndoe", "johndoe@example.com", "", "France", "Paris", 17, "1234567890", "ABC Inc", "Male");

        // Perform checkRequest
        ErrorMessage result = request.checkRequest();

        // Assert that the result is the expected error message
        assertEquals(ErrorMessage.NO_NAME, result);
    }
}
