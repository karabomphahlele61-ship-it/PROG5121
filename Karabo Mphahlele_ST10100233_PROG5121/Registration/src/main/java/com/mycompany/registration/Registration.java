/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration;
import javax.swing.JOptionPane;
/**
 *
 * @author Student
 */


public class Registration {
    public static void main(String[] args) {

        Login login = new Login();

        // ===== REGISTRATION =====
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");
        String phone = JOptionPane.showInputDialog("Enter phone number (e.g. +27831234567):");

        String registrationMessage = login.registerUser(
                username, password, phone, firstName, lastName
        );

        JOptionPane.showMessageDialog(null, registrationMessage);

        // Only allow login if registration successful
        if (registrationMessage.equals("User has been registered successfully.")) {

            // ===== LOGIN =====
            String loginUsername = JOptionPane.showInputDialog("Enter username to login:");
            String loginPassword = JOptionPane.showInputDialog("Enter password to login:");

            boolean loginSuccess = login.loginUser(loginUsername, loginPassword);
            String loginMessage = login.returnLoginStatus(loginSuccess);

            JOptionPane.showMessageDialog(null, loginMessage);
        } else {
            JOptionPane.showMessageDialog(null, "Fix the errors before attempting to log in.");
        }
    }
}
