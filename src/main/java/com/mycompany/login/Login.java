/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author lab_services_student
 */
import java.util.regex.*;

public class Login {

    private String registeredUsername;
    private String registeredPassword;

    // 1. Username validation
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // 2. Password complexity check
    public boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return password.matches(regex);
    }

    // 3. Cellphone number validation (e.g., +1234567890)
    public boolean checkCellphoneNumber(String cellNumber) {
        return cellNumber.startsWith("+") && cellNumber.length() >= 10 && cellNumber.length() <= 15 && cellNumber.substring(1).matches("\\d+");
    }

    // 4. Registration message
    public String registerUser(String username, String password, String cellNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted please ensure that your username contains an underscore and is no more than 5 characters.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Passsword is not correctly formatted please ensure that the password contains atleast eight characters, a capital letter, anumber and a special character";
        }
        if (!checkCellphoneNumber(cellNumber)) {
            return "Cellphone number is incorrectly formatted or missing country code.";
        }

        this.registeredUsername = username;
        this.registeredPassword = password;
        return "User has been registered successfully!";
    }

    // 5. Verify login details
    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }

    // 6. Login message
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome "+username+"t is great to see you";
        } else {
            return "Login failed. Please check your username and password.";
        }
    }

    // Sample usage
    public static void main(String[] args) {
        Login user = new Login();

        String username = "u_ser";
        String password = "Secure1@";
        String phone = "+1234567890";

        System.out.println(user.registerUser(username, password, phone)); // Registration
        System.out.println(user.returnLoginStatus("u_ser", "Secure1@"));       // Login
        System.out.println(user.returnLoginStatus("u_ser", "wrongpass"));      // Failed login
    }
}

    

