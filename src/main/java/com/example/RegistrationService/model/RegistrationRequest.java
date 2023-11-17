package com.example.RegistrationService.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * RegistrationRequest class
 * 
 * Represents a registration request containing user information.
 * 
 * This class encapsulates the details of a user registration request, including validation logic for mandatory parameters.
 * 
 * @author Hamza Ennaoui
 * 
 */
public class RegistrationRequest {

    String username;
    String name;
    String email;
    String password;
    String country;
    String city;
    Integer age;
    String phoneNumber;
    String company;
    String gender;

    /**
     * Constructs a RegistrationRequest with the specified user information.
     * 
     * @param name The name of the user
     * @param username The username of the user
     * @param email The email of the user
     * @param password The password of the user
     * @param country The country of the user
     * @param city The city of the user
     * @param age The age of the user
     * @param phoneNumber The phone number of the user
     * @param company The company of the user
     * @param gender The gender of the user
     */
    public RegistrationRequest(String name, String username, String email, String password, String country, String city,
            int age, String phoneNumber, String company, String gender) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.country = country;
        this.city = (city != null) ? city : "No info";
        this.age = age;
        this.phoneNumber = (phoneNumber != null) ? phoneNumber : "No info";
        this.company = (company != null) ? company : "No info";
        this.gender = (gender != null) ? gender : "No info";
    }

    /**
     * Validate the registration request and check for mandatory parameters.
     * 
     * @return ErrorMessage indicating the validation status
     */
    public ErrorMessage checkRequest() {

        if (this.name.isEmpty()) {
            return ErrorMessage.NO_NAME;
        }
        if (this.username.isEmpty()) {
            return ErrorMessage.NO_USERNAME;
        }
        if (this.email.isEmpty()) {
            return ErrorMessage.NO_EMAIL;
        }
        if (this.password.isEmpty()) {
            return ErrorMessage.NO_PASSWORD;
        }
        if (this.country.isEmpty()) {
            return ErrorMessage.NO_COUNTRY;
        }
        if (!this.country.equalsIgnoreCase("France")) {
            return ErrorMessage.OUTSIDE_FRANCE;
        }
        if (this.age == null) {
            return ErrorMessage.NO_AGE;
        }
        if (this.age < 18) {
            return ErrorMessage.UNDERAGE;
        }

        return ErrorMessage.NO_ERROR;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Get a JSON representation of the registration request.
     * 
     * @return JSON representation of the registration request
     */
    @Override
    public String toString() {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(this).toString();
        } catch (JsonProcessingException e) {
            return this.name;
        }
    }

}
