/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {

    Login login = new Login();

    // =========================
    // USERNAME TESTS
    // =========================

    @Test
    public void testUsernameCorrectlyFormatted() {
        boolean result = login.checkUserName("kyl_1");
        assertTrue(result);
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        boolean result = login.checkUserName("Kyle!!!!!!");
        assertFalse(result);
    }

    // =========================
    // PASSWORD TESTS
    // =========================

    @Test
    public void testPasswordMeetsComplexity() {
        boolean result = login.checkPasswordComplexity("Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testPasswordFailsComplexity() {
        boolean result = login.checkPasswordComplexity("password");
        assertFalse(result);
    }

    // =========================
    // PHONE NUMBER TESTS
    // =========================

    @Test
    public void testCellPhoneCorrectFormat() {
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertTrue(result);
    }

    @Test
    public void testCellPhoneIncorrectFormat() {
        boolean result = login.checkCellPhoneNumber("08966553");
        assertFalse(result);
    }

    // =========================
    // LOGIN TESTS
    // =========================

    @Test
    public void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        boolean result = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        boolean result = login.loginUser("wrongUser", "wrongPass");
        assertFalse(result);
    }

    // =========================
    // ASSERT EQUALS (MESSAGES)
    // =========================

    @Test
    public void testUsernameErrorMessage() {
        String message = login.registerUser("Kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        assertEquals(
            "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
            message
        );
    }

    @Test
    public void testPasswordErrorMessage() {
        String message = login.registerUser("kyl_1", "password", "+27838968976", "Kyle", "Smith");

        assertEquals(
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
            message
        );
    }

    @Test
    public void testPhoneErrorMessage() {
        String message = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");

        assertEquals(
            "Cell phone number incorrectly formatted or does not contain international code.",
            message
        );
    }

    @Test
    public void testSuccessfulRegistrationMessage() {
        String message = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        assertEquals(
            "User has been registered successfully.",
            message
        );
    }
}