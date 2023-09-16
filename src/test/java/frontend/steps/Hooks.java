package frontend.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;

@Slf4j
public class Hooks {
    public WebDriver driver;
    @BeforeAll
    public static void cleanFramework(){
        log.info("Cleaning the screenshot Directory");
        try {
            FileUtils.cleanDirectory(new File("src/test/screenshots/"));
        }
        catch (IOException  | IllegalArgumentException e){
            log.error("Failed to clean the screenshot Directory.");
        }
    }

    @Before
    public void setUp(){
        setDriver();
        log.info("driver is initialized.");
    }

    private void setDriver() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {

        return driver;
    }

    @After
    public void tearDown(Scenario s) {
        if(s.isFailed()){
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot,new File("src/test/screenshots/" + s.getName() + ".png"));
                log.error("Screenshot saved to: "+ "screenshots/"+ s.getName() + ".png");
            } catch (IOException e) {
                log.error("Failed to take screenshot.");
            }
        }
        if(driver != null)
            getDriver().quit();
        log.info("driver is closed.");
    }


}
