package com.mycompany.asessmentaccount;

import java.util.List;
import java.util.Scanner;
/**
 * the following code was created by the second member of the group project
 * @author Group Member 2
 */
public class AsessmentAccount {

    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        Scanner scanner = new Scanner(System.in);

        User adminUser = null; // Store the admin user once logged in

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. List All Users");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                // Sign up a new user
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Is this an admin user? (true/false): ");
                boolean isAdmin = scanner.nextBoolean();
                userManagement.signUp(username, password, name, isAdmin);
                System.out.println("User signed up successfully.");
            } else if (choice == 2) {
                // Log in with username and password
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                User loggedInUser = userManagement.logIn(username, password);
                if (loggedInUser != null) {
                    System.out.println("Logged in as: " + loggedInUser.getName());
                    if (loggedInUser.isAdmin()) {
                        System.out.println("You are an admin user.");
                        adminUser = loggedInUser; // Store the admin user
                    }
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else if (choice == 3) {
                // Update User
                if (adminUser != null && adminUser.isAdmin()) {
                    System.out.print("Enter the username of the user to update: ");
                    String usernameToUpdate = scanner.nextLine();
                    User userToUpdate = userManagement.findUserByUsername(usernameToUpdate);
                    if (userToUpdate != null) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        userManagement.updateUserDetails(adminUser, userToUpdate, newName, newPassword);
                        System.out.println("User details updated successfully.");
                    } else {
                        System.out.println("User not found.");
                    }
                } else {
                    System.out.println("Permission denied.");
                }
            } else if (choice == 4) {
                // Delete User
                if (adminUser != null && adminUser.isAdmin()) {
                    System.out.print("Enter the username of the user to delete: ");
                    String usernameToDelete = scanner.nextLine();
                    User userToDelete = userManagement.findUserByUsername(usernameToDelete);
                    if (userToDelete != null) {
                        userManagement.deleteUser(adminUser, userToDelete);
                        System.out.println("User deleted successfully.");
                    } else {
                        System.out.println("User not found.");
                    }
                } else {
                    System.out.println("Permission denied.");
                }
            }
            else if (choice == 5) {
                // List All Users
                if (adminUser != null && adminUser.isAdmin()) {
                    List<User> allUsers = userManagement.getAllUsers(adminUser);
                    if (allUsers != null) {
                        if (!allUsers.isEmpty()) {
                            System.out.println("List of all users:");
                            for (User user : allUsers) {
                                System.out.println("Username: " + user.getUsername() + ", Name: " + user.getName());
                            }
                        } else {
                            System.out.println("No users found.");
                        }
                    } else {
                        System.out.println("Permission denied.");
                    }
                } else {
                    System.out.println("Permission denied.");
                }
            }

            else if (choice == 6) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
