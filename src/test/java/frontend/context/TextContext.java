package frontend.context;

import backend.HttpHelper;
import frontend.pages.HomePage;
import frontend.utils.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
public class TextContext {


    public WebDriver getDriver() {
        return WebDriverManager.initlaizeDriver();
    }

    public void login(String email, String password) throws URISyntaxException, IOException, InterruptedException {
        HttpHelper.login(getDriver(), email, password);
        log.info("Logged in successfully.");
    }

    public HomePage getHomePage() {
        log.info("Trying to access homepage.");
        return new HomePage(getDriver());
    }


}

