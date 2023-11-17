package com.example.RegistrationService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.RegistrationService.controllers.DisplayController;
import com.example.RegistrationService.model.User;
import com.example.RegistrationService.repository.UserRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class DisplayControllerTest {

     @InjectMocks
    private DisplayController displayController;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testDisplayUserFound() {
        // Mock username
        String username = "john_doe";

        // Mock user found in the database
        User user = new User("UDSQFNFVKVK23434", "John Doe", "john_doe", "john.doe@example.com", "password", "USA", "New York", 30, "1234567890", "ABC Inc", "Male");
        when(userRepository.findUserByUsername(username)).thenReturn(Optional.of(user));

        // Perform display
        ResponseEntity<?> response = displayController.display(username);

        // Assert user found
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Add assertions for the response body based on the expected user details
    }

    @Test
    public void testDisplayUserNotFound() {
        // Mock username
        String username = "jane_smith";

        // Mock user not found in the database
        when(userRepository.findUserByUsername(username)).thenReturn(Optional.empty());

        // Perform display
        ResponseEntity<?> response = displayController.display(username);

        // Assert user not found
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        // Add assertions for the response body based on the expected error message
    }
}
