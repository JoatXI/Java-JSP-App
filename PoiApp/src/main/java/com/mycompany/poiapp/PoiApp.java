package com.mycompany.poiapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joat
 */
public class PoiApp {

    public static void main(String[] args) {
        String location = "", type = "", name = "", comment = "";
        
        Scanner optionMenu = new Scanner(System.in);
        Scanner userTyping = new Scanner(System.in);
        
        Location poi = new Location("Southampton Attractions");
        
        poi.addPlaces(new Places ("Brewster", "Pub", "London Road", comment));
        poi.addPlaces(new Places("Eaters", "Restaurant", "Bedford", comment));
        poi.addPlaces(new Places ("Artsy", "Museum", "The Commons", comment));
        
        int likedPoi = 0;
        boolean endLoop = false;
        while(endLoop == false) {
            System.out.println("\n");
            System.out.println("1. Search for point of interest by location.\n");
            System.out.println("2. Serach for points of interest by type.\n");
            System.out.println("3. Like a point of interest.\n");
            System.out.println("4. Add/Modify a comment on a point of interest.\n");
            System.out.println("5. View previous comments.\n");
            System.out.println("6. Quit Application.\n");
            
            System.out.println("Select an option: ");
            try {
                int userInput = optionMenu.nextInt();

                if(userInput == 1) {
                    System.out.println("Enter point of interest location: ");
                    location = userTyping.nextLine();

                    ArrayList<Places> searchedLocation = poi.findPoiByLocation(location);
                    System.out.println(searchedLocation);
                }

                else if(userInput == 2) {
                    System.out.println("Enter point of interest type: ");
                    type = userTyping.nextLine();

                    ArrayList<Places> searchedType = poi.findPoiByType(type);
                    System.out.println(searchedType);
                }

                else if(userInput == 3) {
                    System.out.println("Choose a POI to add to your likes.\n");

                    System.out.println("1. Name: Brewster, Type: Pub.\n");
                    System.out.println("2. Name: Eaters, Type: Restaurant.\n");
                    System.out.println("3. Name: Artsy, Type: Meseum.\n");

                    System.out.println("Pick an option number: ");
                    int optionInput = optionMenu.nextInt();

                    if(optionInput == 1) {
                        System.out.println("Brewster Poi has been liked!\n");
                        likedPoi += 1;   
                    }
                    else if(optionInput == 2) {
                        System.out.println("Eaters Poi has been liked!\n");
                        likedPoi += 1;
                    }
                    else if(optionInput == 3) {
                        System.out.println("Eaters Poi has been liked!\n");
                        likedPoi += 1;
                    }
                }

                else if(userInput == 4) {
                    System.out.println("Choose a POI to add or modify a previous comment.\n");

                    System.out.println("1. Name: Brewster, Type: Pub, Location: London Road.\n");
                    System.out.println("2. Name: Eaters, Type: Restaurant, Location: Bedford.\n");
                    System.out.println("3. Name: Artsy, Type: Museum, Location: The Commons.\n");

                    System.out.println("Enter Poi name: ");
                    name = userTyping.nextLine();

                    System.out.println("Enter your comment: ");
                    comment = userTyping.nextLine();

                    poi.updateComment(name, comment);

                    System.out.println("Comment added successfully!\n");
                }

                else if(userInput == 5) {
                    ArrayList allComments = poi.commentList();
                    if(allComments.isEmpty()) {
                        System.out.println("No comments available");
                    }
                    else {
                        System.out.println("POIs comments:\n" + allComments);
                    }
                }

                else if(userInput == 6) {
                    endLoop = true;
                }
            }
            
            catch(java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid NUMBER(integer) option.\n");
                optionMenu.next(); // Consume the invalid input
            }
        }
    }
}
