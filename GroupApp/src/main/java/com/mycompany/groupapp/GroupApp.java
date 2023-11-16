package com.mycompany.groupapp;

// Omoohwo's code starts here
import java.util.ArrayList;
import java.util.Scanner; // Omoohwo's code ends here

/**
 *
 * @author Omoohwo and Adetunji
 */
import java.util.List; // Adetunji's code

public class GroupApp { // Group code

    public static void main(String[] args) { // Group code
        // Adetunji code starts here
        UserManagement userManagement = new UserManagement();
        Scanner scanner = new Scanner(System.in);

        User adminUser = null; // Store the admin user once logged in... Adetunji's code ends here
        
        // Omoohwo's code starts here
        String location = "", type = "", name = "", comments = "";
        
        // Creating Scanner objects to take user input
        Scanner optionMenu = new Scanner(System.in);
        Scanner userTyping = new Scanner(System.in);
        
        // Creating a new instance of the Locations class representing a collection of POIs
        Locations places = new Locations("Nigeria Attractions");
        
        // Adding sample POIs
        places.addPoi(new Poi ("Koko Bar", "Bar", "Lagos"));
        places.addPoi(new Poi("Buka Hut", "Restaurant", "Delta"));
        places.addPoi(new Poi ("Yaya Meseum", "Museum", "Abuja"));
        places.addPoi(new Poi ("Iya Basira", "Restaurant", "Ibadan")); 
        
        // Variable to control the application loop
        boolean endLoop = false;
        while(endLoop == false) { // Application loop for user interaction
            System.out.println("\n");
            System.out.println("1. Search for point of interest by location.\n");
            System.out.println("2. Search for points of interest by type.\n");
            System.out.println("3. Like a point of interest.\n");
            System.out.println("4. View Liked point of interests.\n");
            System.out.println("5. Add a comment on a point of interest.\n");
            System.out.println("6. Modify a previous comment on a point of interest.\n");
            System.out.println("7. View previous POIs comments.\n"); // Omoohwo's code ends here
            // Adetunji's code starts here
            System.out.println("8. Sign up.\n");
            System.out.println("9. Log in.\n");
            System.out.println("10. Update User.\n");
            System.out.println("11. Delete User.\n");
            System.out.println("12. List All Users.\n"); // Adetunji's code ends here
            System.out.println("13. Quit Application.\n"); // Ommohwo's code
            
            // Omoohwo's code starts here
            System.out.println("Select an option: ");
            try { // Handling user input with exception handling for non-integer inputs
                int userInput = optionMenu.nextInt();

                if(userInput == 1) {
                    // Searching for POIs by location
                    System.out.println("\nEnter point of interest location: ");
                    location = userTyping.nextLine();
                    
                    // Find and display POIs based on the specified location
                    ArrayList<Poi> searchedLocation = places.findPoiByLocation(location);
                    System.out.println(searchedLocation);
                }

                else if(userInput == 2) {
                    // Search for POIs by type
                    System.out.println("\nEnter point of interest type: ");
                    type = userTyping.nextLine();
                    
                    // Find and displays POIs based on the specified type
                    ArrayList<Poi> searchedType = places.findPoiByType(type);
                    System.out.println(searchedType);
                }

                else if(userInput == 3) {
                    // Like a point of interest
                    System.out.println("\nChoose a POI to add to your likes.\n");
                    
                    // Display POIs in a stack-like order
                    ArrayList<Poi> poiList = places.displayPoiStack();
                    // It contains POIs in a stack-like order
                    for(Poi currentPoi : poiList) {
                        System.out.println(currentPoi);
                    }
                    
                    // Prompt user to enter a POI name to add to likes
                    System.out.println("\nEnter Poi name to add to like: ");
                    name = userTyping.nextLine();
                    
                    // Attempt to like the specified POI
                    boolean likeSuccessful = places.likePoi(name);
                    if(likeSuccessful) {
                        System.out.println("\nPOI added to like!");
                    } else {
                        System.out.print("\nPOI already added to like or not found!");
                    }
                }
                
                else if(userInput == 4) {
                    // View Liked point of interests
                    // Displays the total number of liked POIs
                    int likeCount = places.likeList();
                    System.out.println("\nTotal liked POIs: " + likeCount);
                }

                else if(userInput == 5) {
                    // Add a comment on a point of interest
                    System.out.println("\nChoose a POI to add a comment.\n");
                    
                    // Display POIs in a stack-like order
                    ArrayList<Poi> poiList = places.displayPoiStack();
                    // It contains POIs in a stack-like order
                    for(Poi currentPoi : poiList) {
                        System.out.println(currentPoi);
                    }
                    
                    // Prompt user to enter a POI name and comment
                    System.out.println("\nEnter Poi name: ");
                    name = userTyping.nextLine();

                    System.out.println("\nEnter your comment: ");
                    comments = userTyping.nextLine();
                    
                    // Add a comment to the specified POI
                    places.addPoiComment(name, comments);

                    System.out.println("\nComment added successfully!\n");
                }
                
                else if(userInput == 6) {
                    // Modify a previous comment on a point of interest
                    System.out.println("\nChoose a POI to modify previous comment.\n");
                    
                    // Display POIs in a stack-like order
                    ArrayList<Poi> poiList = places.displayPoiStack();
                    // It contains POIs in a stack-like order
                    for(Poi currentPoi : poiList) {
                        System.out.println(currentPoi);
                    }
                    
                    // Prompt user to enter a POI name
                    System.out.println("\nEnter Poi name: ");
                    name = userTyping.nextLine();
                    
                    // Display comments for the specified POI
                    ArrayList allComments = places.getCommentsForPoi(name);
                    if(allComments.isEmpty()) {
                        System.out.println("\nNo comments available");
                    } else {
                        System.out.println("\nPOIs comments:\n" + allComments);
                    }
                    
                    // Prompt user to enter a comment index and new comment
                    System.out.println("\nEnter the comment index: ");
                    int optionInput = optionMenu.nextInt();
                    
                    System.out.println("\nEnter your new comment: ");
                    comments = userTyping.nextLine();
                    
                    // Update the specified comment for the POI
                    places.updateCommentForPoi(name, optionInput, comments);
                    System.out.println("\nComment updated successfully!\n");
                }

                else if(userInput == 7) {
                    // View previous POIs comments
                    // Display comments for all POIs
                    ArrayList allComments = places.commentList();
                    if(allComments.isEmpty()) {
                        System.out.println("\nNo comments available");
                    } else {
                        System.out.println("\nPOIs comments:\n" + allComments);
                    }
                } // Omoohwo's code ends here
                
                // Adetunji's code starts here
                else if (userInput == 8) {
                    // Sign up a new user
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String firstName = scanner.nextLine(); // variable name had to be changed from "name" to "firstName" as Omoohwo's code has a variable with the same name... Group work
                    System.out.print("Is this an admin user? (true/false): ");
                    boolean isAdmin = scanner.nextBoolean();
                    scanner.nextLine(); // Consumes the newline character... Group code
                    userManagement.signUp(username, password, firstName, isAdmin);
                    System.out.println("User signed up successfully.");
                } 
                
                else if (userInput == 9) {
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
                } 
                
                else if (userInput == 10) {
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
                } 
                
                else if (userInput == 11) {
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
                
                else if (userInput == 12) {
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
                } // Adetunji's code ends here
                
                // Omoohwo's code start here
                else if(userInput == 13) {
                    // Quits Application
                    endLoop = true;
                }
            }
            // Handling non-integer input errors
            catch(java.util.InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid NUMBER(integer) option.\n");
                optionMenu.next(); // Nulls the invalid input
            } // Omoohwo's code ends here
        }
    }
}
