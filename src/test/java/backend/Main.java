package backend;

import backend.pages.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-web-security");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.rami-levy.co.il/he");
        String u  = HttpHelper.getUser("hamoodka8416@gmail.com","123456Hamod");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String jsonData = "{\"authuser\":" + u + "}";
        System.out.println(jsonData);
        js.executeScript(String.format("window.localStorage.setItem('ramilevy',JSON.stringify(%s))",jsonData));
//        driver.navigate().refresh();
    }
}
//localStorage.setItem("ramilevy", `
//        {"authuser":{
//        "user": {
//        "id": 889341,
//        "first_name": "חמוד",
//        "last_name": "קטיש",
//        "email": "hamoodka8416@gmail.com",
//        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvYXBpLXByb2QucmFtaS1sZXZ5.lots-of-characters-here",
//        "user_id": "99001547565",
//        "identity_card": "315840314",
//        "business": 0,
//        "send_email": 1,
//        "send_sms": 1,
//        "subscribe_at": "2023-09-12 16:19:09",
//        "subscribe_ip": "172.69.128.138",
//        "club_accept_at": "2023-09-12 16:19:09",
//        "club_accept_ip": "172.69.128.138",
//        "club_accept": 1,
//        "send_club_database": 0,
//        "name": "חמוד קטיש",
//        "orders": [],
//        "cards": [],
//        "addresses": [],
//        "popularProducts": "",
//        "features": [],
//        "coupons": []
//        },
//        "orderTokens": [],
//        "shopLists": []
//        }}
//        `);