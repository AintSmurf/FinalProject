package backend;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpFacade {
    public HttpFacade() {
    }

    private static String BASE_URL = "https://api-prod.rami-levy.co.il/api/v2/site/auth/login";


    public static  <T> T  post (String url) throws URISyntaxException, IOException, InterruptedException {
        Gson gson = new Gson();
        String params = gson.toJson(r);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(new URI(BASE_URL+url))
                .POST(HttpRequest.BodyPublishers.ofString(params))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        StatusResponse statusResponse = gson.fromJson(httpResponse.body(), StatusResponse.class);
        statusResponse.setStatusCode(httpResponse.statusCode());
        return  statusResponse;
    }
}
