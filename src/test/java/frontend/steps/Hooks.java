package frontend.steps;

import context.TestContext;
import io.cucumber.java.*;
import pages.HomePage;
import utils.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;

@Slf4j
public class Hooks {

    private static TestContext testContext;
    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @BeforeAll
    public static void cleanFramework() {
        try {
            cleanAndDeleteDirectory("screenshot", "src/test/screenshots/");
            cleanAndDeleteDirectory("reports", "src/test/cucumber-reports/");
        } catch (IOException | IllegalArgumentException e) {
            log.error("Failed to clean one or more directories.");
        }
    }
//    @AfterAll
//    public void closeBrowser(){
//        WebDriver driver =testContext.get("driver");
//        driver.close();
//    }

    private static void cleanAndDeleteDirectory(String name, String path) throws IOException {
        log.info("Cleaning and deleting the " + name + " Directory");
        File directory = new File(path);
        FileUtils.cleanDirectory(directory);
        if (directory.exists() && directory.isDirectory()) {
            FileUtils.deleteDirectory(directory);
            log.info(name + " Directory cleaned and deleted successfully.");
        } else {
            log.info(name + " Directory does not exist or is not a directory.");
        }
    }


    @Before
    public void setUp(Scenario s) {
        WebDriver driver = WebDriverManager.initializeDriver();
        testContext.put("driver", driver);
        testContext.put("homepage",new HomePage(testContext.get("driver")));
        log.info("driver is initialized.");
        log.info(s.getName()+" executed.");
    }

    @After
    public void tearDown(Scenario s) {
        WebDriver driver = testContext.get("driver");
        if (driver != null && s.getSourceTagNames().size() == 1) {
            try {
                if (s.isFailed()) {
                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(screenshot, new File("src/test/screenshots/" + s.getName() + ".png"));
                    log.error("Screenshot saved to: " + "screenshots/" + s.getName() + ".png");
                }
            } catch (IOException e) {
                log.error("Failed to take screenshot.");
            } finally {
                driver.quit();
                log.info("driver is closed.");
            }
        }
    }


}
