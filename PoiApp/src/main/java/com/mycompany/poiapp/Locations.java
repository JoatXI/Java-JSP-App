package com.mycompany.poiapp;

import java.util.ArrayList;

/**
 *
 * @author Joat
 */ 
 
/**
 * Represents a collection of points of interest (POIs) for a specific location.
 * Each Location object has a name and stores POIs in an ArrayList.
 */
public class Locations {
    
    private ArrayList<Poi> poi = new ArrayList<Poi>();
    private String name;
    
    /**
     * Constructs a new Location object with the specified name.
     * 
     * @param nameIn The name of the location.
     */
    public Locations(String nameIn) {
        name = nameIn;
    }
    
    /**
     * Adds a new place to the list of POIs for this location.
     * 
     * @param p The Places object to add.
     */
    public void addPoi(Poi p) {
        poi.add(p);
    }
    
    /**
     * Finds a POI by its name.
     * 
     * @param poiName The name of the POI to find.
     * @return The found Places object or null if not found.
     */
    public Poi findPoiByName(String searchName) {
        String searchNameLower = searchName.toLowerCase(); // Convert the user input to lowercase
        for(int i = 0; i < poi.size(); i++) {
            Poi currentPoi = poi.get(i);
            String currentNameLower = currentPoi.getName().toLowerCase(); // Convert the name to lowercase
            if(currentNameLower.equals(searchNameLower)) {
                return currentPoi;
            }
        }
        return null;
    }
    
    /**
     * Updates the comment of a POI.
     * 
     * @param poiName The name of the POI to update.
     * @param newComment The new comment to set for the POI.
     */
    public void updateComment(String poiName, String newComment) {
        Poi foundPoi = findPoiByName(poiName);
        if (foundPoi != null) {
            foundPoi.setComment(newComment);
        }
    }
    
    /**
     * Finds and returns all POIs with a specific type.
     * 
     * @param searchType The type of POIs to search for.
     * @return A list of Places objects with the specified type.
     */
    public ArrayList<Poi> findPoiByType(String searchType) {
        String searchTypeLower = searchType.toLowerCase(); // Convert the user input to lowercase
        ArrayList<Poi> result = new ArrayList<>();
        for(int i = 0; i < poi.size(); i++) {
            Poi currentPoi = poi.get(i);
            String currentTypeLower = currentPoi.getType().toLowerCase(); // Convert the type to lowercase
            if(currentTypeLower.equals(searchTypeLower)) {
                result.add(currentPoi);
            }
        }
        return result;
    }
    
    /**
     * Finds and returns all POIs with a specific location.
     * 
     * @param searchLocation The location of POIs to search for.
     * @return A list of Places objects at the specified location.
     */
    public ArrayList<Poi> findPoiByLocation(String searchLocation) {
        String searchLocationLower = searchLocation.toLowerCase(); // Convert the user input to lowercase
        ArrayList<Poi> result = new ArrayList<>();
        for(int i = 0; i < poi.size(); i++) {
            Poi currentPoi = poi.get(i);
            String currentLocationLower = currentPoi.getLocation().toLowerCase(); // Convert the location to lowercase
            if(currentLocationLower.equals(searchLocationLower)) {
                result.add(currentPoi);
            }
        }
        return result;
    }
    
    /**
     * Retrieves and returns a list of comments associated with the POIs for this location.
     * 
     * @return A string containing comments of all POIs.
     */
    public ArrayList commentList() {
        ArrayList comments = new ArrayList();
        for (int i = 0; i < poi.size(); i++) {
            Poi currentComment = poi.get(i);
            if (currentComment != null) {
                String comment = currentComment.getComment();
                if (comment != null) {
                    comments.add(comment);
                }
            }
        }
        return comments;
    }
}
