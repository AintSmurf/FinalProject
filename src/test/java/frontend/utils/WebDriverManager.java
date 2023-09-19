package frontend.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private static WebDriver driver;
    public static WebDriver initlaizeDriver(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver","src/test/java/drivers/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-site-isolation-trials");
            chromeOptions.addArguments("--disable-web-security");
            chromeOptions.addArguments("--allow-running-insecure-content");
            chromeOptions.addArguments("--disable-content-security-policy");
            driver = new ChromeDriver(chromeOptions);

        }
        return driver;
    }

}
