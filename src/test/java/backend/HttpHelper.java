package backend;

import backend.pom.HttpResponseAndFormattedJson;
import backend.pom.User;
import backend.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

@Slf4j
public class HttpHelper {
    private static HttpResponseAndFormattedJson httpResponseAndFormattedJson;
    private static JavascriptExecutor js;

    public static String getToken(String email, String password) throws URISyntaxException, IOException, InterruptedException {
        HashMap<String, String> userDet = Utils.getUserNameMap(email, password);
        String url = "/site/auth/login";
        httpResponseAndFormattedJson = HttpFacade.post(url, userDet, User.class);
        String jsonData = "{\"authuser\":" + httpResponseAndFormattedJson.getFormattedJsonResponse() + "}";
        return jsonData;
    }

    public static User getUserDetails(String email, String password) throws URISyntaxException, IOException, InterruptedException {
        HashMap<String,String> userDet = Utils.getUserNameMap(email,password);
        String url = "/site/auth/login";
        httpResponseAndFormattedJson =  HttpFacade.post(url,userDet, User.class);
        return (User) httpResponseAndFormattedJson.getData();
    }

    public static void login(WebDriver driver, String email, String password) throws URISyntaxException, IOException, InterruptedException {
        String json = getToken(email, password);
        Utils.waitTillScriptExecutedStringFormat(driver, 20, json, 50);
        Utils.waitTillScriptExecuted(driver, 30, "return window.localStorage.getItem('ramilevy') !== null;");
    }

}
