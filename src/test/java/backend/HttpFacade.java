package backend;

import backend.pages.User;
import backend.pages.Userdetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class HttpFacade {
    public HttpFacade() {
    }

    private static String BASE_URL = "https://api-prod.rami-levy.co.il/api/v2";


    public static <T> String post (String url, HashMap<String, String> userDet, Class<T> clz) throws URISyntaxException, IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Create Gson instance with pretty printing
        String params = new Gson().toJson(userDet);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(new URI(BASE_URL+url))
                .POST(HttpRequest.BodyPublishers.ofString(params))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String formattedJsonResponse = gson.toJson(JsonParser.parseString(httpResponse.body()));
//        System.out.println(formattedJsonResponse);
//        T result=  gson.fromJson(httpResponse.body(), clz);
//        try {
//            Userdetails userdetails = ((User) result).getUser();
////            System.out.println(userdetails);
//        }
//        catch (Exception e){
//            System.out.println("Failed to convert.");
//        }
        return  formattedJsonResponse;
    }


}
