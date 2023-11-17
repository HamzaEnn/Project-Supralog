package com.example.RegistrationService.model;

/**
 * Enum class representing error messages for the RegistrationService and DisplayService.
 * 
 * @author Hamza Ennaoui
 * 
 */

public enum ErrorMessage {
    NO_NAME("Name is required"),
    NO_USERNAME("Username is required"),
    NO_EMAIL("Email is required"),
    NO_PASSWORD("Password is required"),
    NO_COUNTRY("Country is required"),
    NO_AGE("Age is required"),
    UNDERAGE("Age must be at least 18"),
    OUTSIDE_FRANCE("Your country isn't supported by our service"),
    EMAIL_MATCHED("An account is already registered by this email"),
    USERNAME_MATCHED("An account is already registered by this username"),
    USER_NOT_FOUND("User not found"),
    NO_ERROR("");

    private final String message;

    /**
     * Constructs an ErrorMessage with the specified message.
     * 
     * @param message The error message
     */
    ErrorMessage(String message) {
        this.message = message;
    }

    /**
     * Get the error message.
     * 
     * @return The error message
     */
    public String getMessage() {
        return message;
    }
}
