package backend;

import backend.pom.HttpResponseAndFormattedJson;
import backend.pom.User;
import backend.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Objects;

public class HttpHelper {
    private static HttpResponseAndFormattedJson httpResponseAndFormattedJson;

    public static String getToken(String email, String password) throws URISyntaxException, IOException, InterruptedException {
        HashMap<String,String> userDet = Utils.getUserNameMap(email,password);
        String url = "/site/auth/login";
        httpResponseAndFormattedJson =  HttpFacade.post(url,userDet, User.class);
        String jsonData = "{\"authuser\":" + httpResponseAndFormattedJson.getFormattedJsonResponse() + "}";
        return jsonData;
    }
    public static User getUserDetails(String email, String password) throws URISyntaxException, IOException, InterruptedException {
        HashMap<String,String> userDet = Utils.getUserNameMap(email,password);
        String url = "/site/auth/login";
        httpResponseAndFormattedJson =  HttpFacade.post(url,userDet, User.class);
        return (User) httpResponseAndFormattedJson.getData();
    }
}
