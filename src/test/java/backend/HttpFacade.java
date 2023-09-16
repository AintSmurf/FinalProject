package backend;

import backend.pom.HttpResponseAndFormattedJson;
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


    public static  <T> HttpResponseAndFormattedJson<T> post (String url, HashMap<String, String> userDet, Class<T> clz) throws URISyntaxException, IOException, InterruptedException {
        //objects
        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        //convert the user details map to json
        String params = new Gson().toJson(userDet);

        //make the request
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(new URI(BASE_URL+url))
                .POST(HttpRequest.BodyPublishers.ofString(params))
                .build();
        //create httpclient to handle the response
        HttpClient httpClient = HttpClient.newHttpClient();

        //capture the response
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        //convert the response to String to set the localStorage
        String formattedJsonResponse = gson.toJson(JsonParser.parseString(httpResponse.body()));

        //convert response to pom through SerializedName
        T result=  gson.fromJson(httpResponse.body(), clz);

        return new HttpResponseAndFormattedJson<>(httpResponse, formattedJsonResponse,result);
    }


}