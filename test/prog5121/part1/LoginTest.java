/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121.part1;

import org.junit.Test; 
import static org.junit.Assert.*;
/**
 *
 * @author Student
 */
public class LoginTest {
    Login login = new Login();

    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testRegistrationUsernameErrorString() {
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegistrationPasswordErrorString() {
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        String actual = login.registerUser("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegistrationCellNumberErrorString() {
        String expected = "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertEquals(expected, actual);
    }

    @Test
    public void testSuccessfulLoginStatusString() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        boolean auth = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        String expected = "Welcome Kyle ,Smith it is great to see you.";
        assertEquals(expected, login.returnLoginStatus(auth));
    }

    @Test
    public void testFailedLoginStatusString() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        boolean auth = login.loginUser("wrong_user", "wrong_pass");
        String expected = "Username or password incorrect, please try again.";
        assertEquals(expected, login.returnLoginStatus(auth));
    }
}