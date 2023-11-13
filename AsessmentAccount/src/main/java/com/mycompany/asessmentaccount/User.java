package com.mycompany.asessmentaccount;

/**
 * the following code was created by the second member of the group project
 * @author Group Member 2
 */
class User {
    private String username;
    private String password;
    private String name;
    private boolean isAdmin;

    public User(String username, String password, String name, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    // Getters and setters for user properties
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
