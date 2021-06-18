package com.example.greetingappdevelopment.greetingappmodal;

public class User {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        String string = (firstName != null) ? firstName + " " : "";
        string += (lastName != null) ? lastName : "";
        return string.trim();
    }

}
