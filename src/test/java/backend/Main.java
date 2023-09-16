package backend;

import backend.pom.User;
import backend.utils.Utils;
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
        String token  = HttpHelper.getToken("hamoodka8416@gmail.com","123456Hamod");
        User userDet = HttpHelper.getUserDetails("hamoodka8416@gmail.com","123456Hamod");
        System.out.println(userDet);

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript(String.format("window.localStorage.setItem('ramilevy',JSON.stringify(%s));",token));
        Utils.waitTillScriptExecuted(driver, 20, "return localStorage.getItem('ramilevy') !== null;");

        driver.navigate().refresh();
    }
}
