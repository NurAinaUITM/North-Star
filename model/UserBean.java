package model;

public class UserBean {
    private String email;
    private String password;
    // Add other fields if needed (e.g., name, role)

    // Empty Constructor
    public UserBean() {}

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
