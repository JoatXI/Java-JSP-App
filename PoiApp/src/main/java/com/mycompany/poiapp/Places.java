package com.mycompany.poiapp;

/**
 *
 * @author Joat
 */
 
/**
 * Represents a point of interest (POI).
 * 
 * This class stores information about a POI, including its name, type, location, and comment.
 */
public class Places {
    private String name, type, location, comment;
    
    /**
     * Constructs a new Places object.
     * 
     * @param nameIn The name of POI.
     * @param typeIn The type of POI.
     * @param locationIn The location of the POI.
     * @param commentIn The comment associated with the POI.
     */
    public Places(String nameIn, String typeIn, String locationIn, String commentIn) {
        this.name = nameIn;
        this.type = typeIn;
        this.location = locationIn;
        this.comment = commentIn;
    }
    
    /**
     * Returns a string representation of the POI.
     * 
     * @return A string in the format: "Type: [type], Name: [name], Location: [location]"
     */
    public String toString() {
        return "Type: " + this.type + ", Name: " + this.name + ", Location: " + this.location;
    }
    
    /**
     * Gets the type of the POI.
     * 
     * @return The type of the POI.
     */
    public String getType() {
        return this.type;
    }
    
    /**
     * Gets the name of the POI.
     * 
     * @return The name of the POI.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the location of the POI.
     * 
     * @return The location of the POI.
     */

    public String getLocation() {
        return this.location;
    }
    
    /**
     * Gets the comment associated with the POI.
     * 
     * @return The comment for the POI.
     */
    public String getComment() {
        return this.comment;
    }
    
     /**
     * Sets the comment for this point of interest (POI).
     * 
     * @param comment The new comment to set.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
