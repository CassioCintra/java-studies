package studies.client;

import studies.client.exception.ApiException;
import studies.config.ConfigLoader;
import studies.model.entity.ApodEntity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Apod {
    private final HttpClient client = HttpClient.newHttpClient();

    private String getApiInfo() {
        Map<String, Object> config = ConfigLoader.loadConfig("application.yml");
        Map<String, Object> api = (Map<String, Object>) config.get("api");
        return (String) api.get("apod");
    }

    public ApodEntity getData() {
        String apiInfo = getApiInfo();
        try {
            HttpRequest request = HttpRequest.newBuilder(URI.create(apiInfo)).GET().build();
            HttpResponse<String > response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            String date = extractField(responseBody, "date");
            String explanation = extractField(responseBody, "explanation");
            String mediaType = extractField(responseBody, "media_type");
            String serviceVersion = extractField(responseBody, "service_version");
            String title = extractField(responseBody, "title");
            String url = extractField(responseBody, "url");

            return new ApodEntity(
                    date,
                    explanation,
                    mediaType,
                    serviceVersion,
                    title,
                    url
            );
        } catch (IOException | InterruptedException e){
            throw new ApiException("Error processing API response: " + e.getMessage());
        }
    }

    private String extractField(String json, String field) {
        try {
            return json.split("\"" + field + "\":\"")[1].split("\"")[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
}
