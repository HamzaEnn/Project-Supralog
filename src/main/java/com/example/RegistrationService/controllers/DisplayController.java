package com.example.RegistrationService.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.RegistrationService.model.ErrorMessage;
import com.example.RegistrationService.model.LogMessage;
import com.example.RegistrationService.model.User;
import com.example.RegistrationService.repository.UserRepository;

/**
 * DisplayController class
 * 
 * Controller for the display service
 * 
 * @author Hamza Ennaoui
 */
@RestController
public class DisplayController {


    /**
     * userRepository Repository containing all the users
     */
	@Autowired
	UserRepository userRepository;

    /**
     * display user based on the provided username
     * @param username The username of the user to be displayed
     * @return ResponseEntity containing the user information or an error message
     */
    @GetMapping("/display/{username}")
	public ResponseEntity<?> display(@PathVariable String username) {

        long start = System.currentTimeMillis();

        Optional<User> user = userRepository.findUserByUsername(username);

        int status;
        String output;

        if (user.isPresent()) {
            status = 200;
            output = user.get().toString();
        } else {
            status = 404;
            output = ErrorMessage.USER_NOT_FOUND.getMessage();
        }

        return ResponseEntity.status(status).body(
            new LogMessage(
                "display : " + username,
                output,
                System.currentTimeMillis() - start
            ).getMessage());

	}
}
