package model;

/**
 * Main user, or account of the person who's using a client instance
 */
public class MainUserModel {
    private String firstName, lastName, username;
    
    public MainUserModel() {
    }
    
    public MainUserModel(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public boolean getStatus() {
        // FIXME rough estimation
        return username != null;
    }
    
}
