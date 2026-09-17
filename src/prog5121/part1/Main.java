/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121.part1;

import java.util.Scanner;
/**
 *
 * @author Student
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login userLogin = new Login();

        System.out.println("=== ACCOUNT REGISTRATION ===");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Cell Phone (+27...): ");
        String cellNumber = scanner.nextLine();

        String regResult = userLogin.registerUser(username, password, cellNumber, firstName, lastName);
        System.out.println("\n" + regResult);

        if (!regResult.contains("successfully captured")) {
            System.out.println("\nRegistration failed. Terminating application.");
            scanner.close();
            return;
        }

        System.out.println("\n=== ACCOUNT LOGIN ===");
        System.out.print("Enter Username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = scanner.nextLine();

        boolean isAuth = userLogin.loginUser(loginUsername, loginPassword);
        System.out.println(userLogin.returnLoginStatus(isAuth));

        scanner.close();
    }
}