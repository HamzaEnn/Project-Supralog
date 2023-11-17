package com.example.RegistrationService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RegistrationService.model.ErrorMessage;
import com.example.RegistrationService.model.LogMessage;
import com.example.RegistrationService.model.RegistrationRequest;
import com.example.RegistrationService.model.User;
import com.example.RegistrationService.repository.UserRepository;

/**
* RegistrationController class
* 
* Controller for the registration service
* 
* This class handles the registration of new users and performs validation on the registration request.
* 
* @author Hamza Ennaoui
*/
@RestController
public class RegistrationController {
    
    @Autowired
    UserRepository userRepository;
    
    /**
    * Register a new user based on the provided registration request.
    * 
    * @param request The registration request containing user information
    * @return ResponseEntity containing the registration status and a log message
    */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        
        long start = System.currentTimeMillis();
        
        int status;
        String output;
        
        // check mandatory user parameters
        ErrorMessage checkParams = request.checkRequest();
        
        if (checkParams != ErrorMessage.NO_ERROR) {
            status = 400; //request error
            output = checkParams.getMessage();
        } else {
            // check if user exists already
            ErrorMessage exists = checkExistance(request.getUsername(), request.getEmail());
            
            if (exists != ErrorMessage.NO_ERROR) {
                status = 400; //request error
                output = exists.getMessage();
                
            } else {
                userRepository.save(new User(request));
                status = 200; //ok
                output = "User registered successfuly";
            }
        }
        
        return ResponseEntity.status(status).body(
            new LogMessage(
                "register " + request.toString(), 
                output,
                System.currentTimeMillis() - start
            ).getMessage());
        
    }

    /**
    * Check if a user with the same username or email already exists.
    * 
    * @param user The registration request containing user information
    * @return ErrorMessage indicating the existence status
    */
    private ErrorMessage checkExistance(String username, String email) {
        
        if ( userRepository.existsByUsername(username)) {
            
            return ErrorMessage.USERNAME_MATCHED;
            
        } else if (userRepository.existsByEmail(email)) {
            
            return ErrorMessage.EMAIL_MATCHED;
            
        } else {
            
            return ErrorMessage.NO_ERROR;
            
        }
    }
    
}
