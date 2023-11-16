package com.mycompany.groupapp;

import java.util.ArrayList;

/**
 *
 * @author Omoohwo
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
     * @param p The Poi object to add.
     */
    public void addPoi(Poi p) {
        poi.add(p);
    }
    
    /**
     * Display POIs in a stack-like manner.
     * 
     * @return An ArrayList containing POIs in a stack-like order.
     */
    public ArrayList<Poi> displayPoiStack() {
        ArrayList<Poi> poiStackList = new ArrayList<>();
        // Iterate through the poi list in reverse order
        for(int i = poi.size() -1; i >= 0; i--) {
            Poi currentPoi = poi.get(i);
            if(currentPoi != null) {
                poiStackList.add(currentPoi);
            }
        }
        return poiStackList;
    }
    
    /**
     * Finds a POI by its name.
     * 
     * @param poiName The name of the POI to find.
     * @return The found Poi object or null if not found.
     */
    public Poi findPoiByName(String poiName) {
        String searchNameLower = poiName.toLowerCase(); // Convert the user input to lowercase
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
     * Finds and returns all POIs with a specific type.
     * 
     * @param searchType The type of POIs to search for.
     * @return A list of Poi objects with the specified type.
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
     * @return A list of Poi objects at the specified location.
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
     * Adds a POI to likes
     * 
     * @param poiName to add to like.
     */
    public boolean likePoi(String poiName) {
        Poi foundPoi = findPoiByName(poiName);
        if(foundPoi != null && !foundPoi.isLiked()) {
            foundPoi.addLikes();
            foundPoi.setLiked(true);// Set the liked flag to true
            return true; // Liked successfully
        }
        return false; // Already liked or POI not found
    }
    
    /**
     * Get total likes for a all POIs.
     * 
     * @return The total number of POI likes.
     */
    public int likeList() {
        int totalLikes = 0;
        for(int i = 0; i < poi.size(); i++) {
            Poi currentPoi = poi.get(i);
            totalLikes += currentPoi.getLikes();
        }
        return totalLikes;
    }
    
    /**
     * Updates the comment of a POI.
     * 
     * @param poiName The name of the POI to update.
     * @param newComment The new comment to set for the POI.
     */
    public void addPoiComment(String poiName, String newComment) {
        Poi foundPoi = findPoiByName(poiName);
        if(foundPoi != null) {
            foundPoi.addComment(newComment);
        }
    }
    
    /**
     * Updates a comment for a specific POI.
     * 
     * @param poiName The name of the POI to update.
     * @param commentIndex The index of the comment to update (0-based index).
     * @param newComment The new comment to set for the POI.
     */
    public boolean updateCommentForPoi(String poiName, int commentIndex, String newComment) {
        Poi foundPoi = findPoiByName(poiName);
        if(foundPoi != null) {
            foundPoi.updateComment(commentIndex, newComment);
        } else {
            return false;
        }
        return true;
    }
    
    /**
     * Get comments for a specific POI.
     * 
     * @param poiName The name of the POI to get comments for.
     * @return A list of comments for the specified POI.
     */
    public ArrayList<String> getCommentsForPoi(String poiName) {
        Poi specificPoi = findPoiByName(poiName);
        if(specificPoi != null) {
            ArrayList poiComments = specificPoi.getComments();
            return poiComments;
        } else {
            return new ArrayList<>(); // Return an empty list if the POI is not found.
        }
    }
    
    /**
     * Retrieves and returns a list of comments associated with the POIs for this location.
     * 
     * @return A string containing comments of all POIs.
     */
    public ArrayList commentList() {
        ArrayList comments = new ArrayList();
        for(int i = 0; i < poi.size(); i++) {
            Poi currentComment = poi.get(i);
            if (currentComment != null) {
                ArrayList<String> comment = currentComment.getComments();
                if (comment != null) {
                    comments.add(comment);
                }
            }
        }
        return comments;
    }
}