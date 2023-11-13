package com.mycompany.poiapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joat
 */
// The main application class for managing Points of Interest (POIs)
public class PoiApp {
    // Main method where the application starts
    public static void main(String[] args) {
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
            System.out.println("7. View previous POIs comments.\n");
            System.out.println("8. Quit Application.\n");
            
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
                    System.out.println("\nEnter point of interest type: ");
                    type = userTyping.nextLine();

                    // Find and displays POIs based on the specified type
                    ArrayList<Poi> searchedType = places.findPoiByType(type);
                    System.out.println(searchedType);
                }

                else if(userInput == 3) {
                    System.out.println("\nChoose a POI to add to your likes.\n");

                    // Display POIs in a stack-like order
                    ArrayList<Poi> poiList = places.displayPoiStack();
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
                    // Displays the total number of liked POIs
                    int likeCount = places.likeList();
                    System.out.println("\nTotal liked POIs: " + likeCount);
                }

                else if(userInput == 5) {
                    System.out.println("\nChoose a POI to add a comment.\n");

                    // Display POIs in a stack-like order
                    ArrayList<Poi> poiList = places.displayPoiStack();
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
                    System.out.println("\nChoose a POI to modify previous comment.\n");

                    // Display POIs in a stack-like order
                    ArrayList<Poi> poiList = places.displayPoiStack();
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
                    // Display comments for all POIs
                    ArrayList allComments = places.commentList();
                    if(allComments.isEmpty()) {
                        System.out.println("\nNo comments available");
                    } else {
                        System.out.println("\nPOIs comments:\n" + allComments);
                    }
                }

                else if(userInput == 8) {
                    // Quits Application
                    endLoop = true;
                }
            }
            // Handling non-integer input errors
            catch(java.util.InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid NUMBER(integer) option.\n");
                optionMenu.next(); // Nulls the invalid input
            }
        }
    }
}