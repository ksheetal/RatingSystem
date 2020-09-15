package com.example.oyeRickshaw.Model;
/*
 * @created 27/08/2020 - 4:02 PM
 * @project hireUs
 * @author  sheetalkumar
 */



public class LoginRequest {


    private String email;

    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
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
}
