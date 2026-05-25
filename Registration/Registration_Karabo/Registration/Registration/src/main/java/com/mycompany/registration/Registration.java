package com.mycompany.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login login = new Login();

        // Registration
        System.out.println("===== REGISTER =====");

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter phone number: ");
        String phone = input.nextLine();

        String registrationMessage = login.registerUser(
                username,
                password,
                phone,
                firstName,
                lastName
        );

        System.out.println(registrationMessage);

        // Login
        if (registrationMessage.equals("User has been registered successfully.")) {

            System.out.println("\n===== LOGIN =====");

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            boolean loginSuccess = login.loginUser(loginUsername, loginPassword);

            String loginMessage = login.returnLoginStatus(loginSuccess);

            System.out.println(loginMessage);

            // Quick chat part
            if (loginSuccess) {
                QuickChat chat = new QuickChat();
                chat.startChat();
            }

        } else {
            System.out.println("Fix errors before login.");
        }
    }
}