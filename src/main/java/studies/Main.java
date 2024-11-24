package studies;

import studies.config.ConfigLoader;

import java.util.Collections;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> config = ConfigLoader.loadConfig("application.yml");

        Map<String, Object> database = (Map<String, Object>) config.get("database");
        System.out.println("Database URL: " + database.get("url"));
        System.out.println("Database URL: " + database.get("username"));
        System.out.println("Database URL: " + database.get("password"));
        System.out.println("Database URL: " + database.get("driver"));

        Map<String, Object> api = (Map<String, Object>) config.get("api");
        System.out.println("API APOD: " + api.get("apod"));
    }
}