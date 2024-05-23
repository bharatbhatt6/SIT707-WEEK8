package web.service;

public class LoginService {
    public static boolean login(String username, String password, String dob) {
        // Check for null or empty values
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            dob == null || dob.trim().isEmpty()) {
            return false;
        }

        // Validate the date format (yyyy-mm-dd)
        if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }

        // Check for correct username, password, and date of birth
        if ("ahsan".equals(username) && "ahsan_pass".equals(password) && "1980-01-01".equals(dob)) {
            return true;
        }

        // Returning false for all other cases
        return false;
    }
}
  
