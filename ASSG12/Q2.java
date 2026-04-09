// You are creating a class that manages user sessions and authentication.
// SessionManager should have functions to login, which compares with the list of tuples
// (tuple of username and password). This list should be an attribute of the
// SessionManager class with usernames and passwords hardcoded. Incorporate singleton
// pattern to ensure that there are no multiple instances of SessionManager in the server
// where it will be deployed.


import java.util.HashMap;

class SessionManager {
    private static SessionManager instance;
    private HashMap<String, String> userCredentials;
    
    private SessionManager() {
        // Private constructor to prevent instantiation
        userCredentials = new HashMap<>();
        // Hardcoded usernames and passwords
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public boolean login(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            System.out.println("Login successful for user: " + username);
            return true;
        } else {
            System.out.println("Login failed for user: " + username);
            return false;
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getInstance();

        // Test login with correct credentials
        sessionManager.login("user1", "password1");
        sessionManager.login("user1", "password1");

        // Test login with incorrect credentials
        sessionManager.login("user2", "wrongpassword");
    }
}

