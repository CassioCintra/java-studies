package studies.config;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ConfigLoader {
    public static Map<String, Object> loadConfig(String file){
        Yaml yaml = new Yaml();
        try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream(file)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + file);
            }
            Map<String, Object> config = yaml.load(inputStream);
            replaceEnvVariables(config);
            return config;
        } catch (Exception e) {
            throw new RuntimeException("Error loading YAML configuration: " + e.getMessage(), e);
        }
    }

    private static void replaceEnvVariables(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                entry.setValue(resolveEnvVariable((String) value));
            } else if (value instanceof Map) {
                replaceEnvVariables((Map<String, Object>) value);
            }
        }
    }

    private static String resolveEnvVariable(String value) {
        if (value.contains("${") && value.contains("}")) {
            int start = value.indexOf("${") + 2;
            int end = value.indexOf("}");
            String envKey = value.substring(start, end);
            String envValue = System.getenv(envKey);
            return value.replace("${" + envKey + "}", envValue != null ? envValue : "");
        }
        return value;
    }
}
