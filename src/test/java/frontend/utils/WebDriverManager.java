package frontend.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static WebDriver driver;
    public static WebDriver initlaizeDriver(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver","src/test/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

}
