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
