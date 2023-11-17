package com.example.RegistrationService.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.RegistrationService.model.User;

/**
 * UserRepository interface
 * 
 * Repository for managing user data in the database extending MongoRepository
 * 
 * @author Hamza Ennaoui
 * 
 */
public interface UserRepository extends MongoRepository<User, String> {
    
    /**
     * Find a user by name.
     * 
     * @param name The name of the user
     * @return Optional containing the user if found, empty otherwise
     */
    @Query("{name:'?0'}")
    Optional<User> findUserByName(String name);

    /**
     * Find a user by username.
     * 
     * @param username The username of the user
     * @return Optional containing the user if found, empty otherwise
     */
    @Query("{username:'?0'}")
    Optional<User> findUserByUsername(String username);

    /**
     * Check if a user exists by username.
     * 
     * @param username The username to check
     * @return true if the user exists, false otherwise
     */
    Boolean existsByUsername(String username);

    /**
     * Check if a user exists by email.
     * 
     * @param email The email to check
     * @return true if the user exists, false otherwise
     */
    Boolean existsByEmail(String email);

}
