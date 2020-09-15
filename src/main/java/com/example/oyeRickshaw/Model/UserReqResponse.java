package com.example.oyeRickshaw.Model;
/*
 * @created 27/08/2020 - 6:37 PM
 * @project hireUs
 * @author  sheetalkumar
 */


public class UserReqResponse {

    private String email;
    private String role;
    private String userID;
    private String message;

    public UserReqResponse() {
    }

    public UserReqResponse(String email, String role, String userID, String message) {
        this.email = email;
        this.role = role;
        this.userID = userID;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}