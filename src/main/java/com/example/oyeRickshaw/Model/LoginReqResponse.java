package com.example.oyeRickshaw.Model;
/*
 * @created 27/08/2020 - 4:03 PM
 * @project hireUs
 * @author  sheetalkumar
 */


public class LoginReqResponse {

    private String email;
    private String role;

    public LoginReqResponse() {
    }

    public LoginReqResponse(String email, String role) {
        this.email = email;
        this.role = role;
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
}
