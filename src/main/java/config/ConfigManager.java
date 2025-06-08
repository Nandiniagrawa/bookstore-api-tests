package config;

public class ConfigManager {
    // Get baseUrl system property or default to localhost:8000
    public static final String BASE_URL = System.getProperty("baseUrl", "http://localhost:8000");

    // Optional: provide a getter method instead of direct field access
    public static String getBaseUrl() {
        return BASE_URL;
    }
}
