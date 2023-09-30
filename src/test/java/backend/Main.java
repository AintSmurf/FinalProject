package backend;
import backend.pom.products.Catalog;
import backend.pom.products.Datum;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import frontend.utils.WaitsBack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.RequestId;
import org.openqa.selenium.devtools.v85.network.model.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;


public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/java/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-web-security");
        Gson gson = new Gson();
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            Response response = responseReceived.getResponse();
            if(response.getUrl().contains("catalog")){
                RequestId requestId = responseReceived.getRequestId();
                String body = devTools.send(Network.getResponseBody(requestId)).getBody();
                try{
                    Catalog c = gson.fromJson(body, Catalog.class);
                    System.out.println(c.getData());
                }
                catch (Exception e){
                    System.out.println(" failed conversion to pom through SerializedName.");
                }


            }
        });

        driver.get("https://www.rami-levy.co.il/he");
        driver.navigate().refresh();
//        WaitsBack.waitTillClickable(driver,10,By.xpath("//*[@id='main-menu-7']"));


//        String token  = HttpHelper.getToken("knawras17@gmail.com","123nawras");
//        User userDet = HttpHelper.getUserDetails("hamoodka8416@gmail.com","123456Hamod");
//        System.out.println(userDet);

//        JavascriptExecutor js = (JavascriptExecutor)driver;
//       Utils.waitTillScriptExecutedStringFormat(driver,20,token);
//       js.executeScript(String.format("window.localStorage.setItem('ramilevy',JSON.stringify(%s));",token));
//       Utils.waitTillScriptExecuted(driver, 20, "return localStorage.getItem('ramilevy') !== null;");
//        HttpHelper.login(driver,"knawras17@gmail.com","123nawras");
//        HttpHelper.getItems();

//        driver.navigate().refresh();
    }
}
