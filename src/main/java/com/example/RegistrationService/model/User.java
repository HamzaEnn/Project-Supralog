package com.example.RegistrationService.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * User class
 * 
 * Represents a user.
 * 
 * @author Hamza Ennaoui
 * 
 */
@Document("users")
public class User {
    
    @Id
    String id;

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
     * Constructs a User with the specified user information.
     * 
     * @param id The unique identifier of the user
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
    public User(String id, String name, String username, String email, String password, String country, String city,
            Integer age, String phoneNumber, String company, String gender) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.country = country;
        this.city = city;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.gender = gender;
    }

    /**
     * Constructs a User based on the provided registration request.
     * 
     * @param request The registration request containing user information
     */
    public User(RegistrationRequest request) {
        this.id = UUID.randomUUID().toString();
        this.name = request.getName();
        this.username = request.getUsername();
        this.email = request.getEmail();
        this.password = request.getPassword();
        this.country = request.getCountry();
        this.city = request.getCity();
        this.age = request.getAge();
        this.phoneNumber = request.getPhoneNumber();
        this.company = request.getCompany();
        this.gender = request.getGender();

    }

    /**
     * Default constructor
     */
    public User() {}

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
     * Get a JSON representation of the user.
     * 
     * @return JSON representation of the user
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
