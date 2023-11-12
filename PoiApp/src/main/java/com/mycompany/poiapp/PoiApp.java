package com.mycompany.poiapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joat
 */
public class PoiApp {

    public static void main(String[] args) {
        String location = "", type = "", name = "", comments = "";
        int likes = 0;
        
        Scanner optionMenu = new Scanner(System.in);
        Scanner userTyping = new Scanner(System.in);
        
        Locations places = new Locations("Nigeria Attractions");
        
        places.addPoi(new Poi ("Koko Bar", "Bar", "Lagos"));
        places.addPoi(new Poi("Buka Hut", "Restaurant", "Delta"));
        places.addPoi(new Poi ("Yaya Meseum", "Museum", "Abuja"));
        places.addPoi(new Poi ("Iya Basira", "Restaurant", "Ibadan"));
        
        
        boolean endLoop = false;
        while(endLoop == false) {
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
            try {
                int userInput = optionMenu.nextInt();

                if(userInput == 1) {
                    System.out.println("\nEnter point of interest location: ");
                    location = userTyping.nextLine();

                    ArrayList<Poi> searchedLocation = places.findPoiByLocation(location);
                    System.out.println(searchedLocation);
                }

                else if(userInput == 2) {
                    System.out.println("\nEnter point of interest type: ");
                    type = userTyping.nextLine();

                    ArrayList<Poi> searchedType = places.findPoiByType(type);
                    System.out.println(searchedType);
                }

                else if(userInput == 3) {
                    System.out.println("\nChoose a POI to add to your likes.\n");

                    ArrayList<Poi> poiList = places.displayPoiStack();
                    // It contains POIs in a stack-like order
                    for(Poi currentPoi : poiList) {
                        System.out.println(currentPoi);
                    }

                    System.out.println("\nEnter Poi name to add to like: ");
                    name = userTyping.nextLine();

                    boolean likeSuccessful = places.likePoi(name);
                    if(likeSuccessful) {
                        System.out.println("\nPOI added to like!");
                    } else {
                        System.out.print("\nPOI already added to like or not found!");
                    }
                }
                
                else if(userInput == 4) {
                    int likeCount = places.likeList();
                    System.out.println("\nTotal liked POIs: " + likeCount);
                }

                else if(userInput == 5) {
                    System.out.println("\nChoose a POI to add a comment.\n");

                    ArrayList<Poi> poiList = places.displayPoiStack();
                    // It contains POIs in a stack-like order
                    for(Poi currentPoi : poiList) {
                        System.out.println(currentPoi);
                    }

                    System.out.println("\nEnter Poi name: ");
                    name = userTyping.nextLine();

                    System.out.println("\nEnter your comment: ");
                    comments = userTyping.nextLine();

                    places.addPoiComment(name, comments);

                    System.out.println("\nComment added successfully!\n");
                }
                
                else if(userInput == 6) {
                    System.out.println("\nChoose a POI to modify previous comment.\n");

                    ArrayList<Poi> poiList = places.displayPoiStack();
                    // It contains POIs in a stack-like order
                    for(Poi currentPoi : poiList) {
                        System.out.println(currentPoi);
                    }
                    
                    System.out.println("\nEnter Poi name: ");
                    name = userTyping.nextLine();
                    
                    ArrayList allComments = places.getCommentsForPoi(name);
                    if(allComments.isEmpty()) {
                        System.out.println("\nNo comments available");
                    } else {
                        System.out.println("\nPOIs comments:\n" + allComments);
                    }
                    
                    System.out.println("\nEnter the comment index: ");
                    int optionInput = optionMenu.nextInt();
                    
                    System.out.println("\nEnter your new comment: ");
                    comments = userTyping.nextLine();
                    
                    places.updateCommentForPoi(name, optionInput, comments);
                    System.out.println("\nComment updated successfully!\n");
                }

                else if(userInput == 7) {
                    ArrayList allComments = places.commentList();
                    if(allComments.isEmpty()) {
                        System.out.println("\nNo comments available");
                    } else {
                        System.out.println("\nPOIs comments:\n" + allComments);
                    }
                }

                else if(userInput == 8) {
                    endLoop = true;
                }
            }
            
            catch(java.util.InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid NUMBER(integer) option.\n");
                optionMenu.next(); // Nulls the invalid input
            }
        }
    }
}