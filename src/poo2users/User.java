package poo2users;

/**
 *
 * @author alumne
 */
public class User {
    
    /**
     * Username.
     */
    private String username;
    /**
     * password. Easy to remember for you, difficult for others.
     */
    private String password;
    /**
     * role. Role in the app: admin, user
     */
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", role=" + role + '}';
    }
    
}
