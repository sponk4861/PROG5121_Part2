/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121.part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Student
 */
public class Login {
    private String username;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;
    //check username
    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }
public boolean checkPasswordComplexity(String password ) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasUpper && hasDigit && hasSpecial;
    }
public boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber == null) return false;
        String regex = "^\\+27[0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cellNumber);
        return matcher.matches();
    }

    public String registerUser(String username, String password, String cellNumber, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
        this.firstName = firstName;
        this.lastName = lastName;

        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername != null && enteredPassword != null &&
               enteredUsername.equals(this.username) &&
               enteredPassword.equals(this.password);
    }

    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + " ," + lastName + " it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getCellNumber() { return cellNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}

