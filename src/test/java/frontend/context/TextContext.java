package frontend.context;

import backend.HttpHelper;
import frontend.pages.HomePage;
import frontend.pages.frozensPages;
import frontend.utils.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
public class TextContext {

    public void login(String email, String password) throws URISyntaxException, IOException, InterruptedException {
        int ret = 0;
        while(ret < 10){
            HttpHelper.login(WebDriverManager.initlaizeDriver(), email, password);
            if(this.getHomePage().getLogin() != null){break;}
            else {
                log.error("failed to execute the script.");
                ret++;
            }
        }
        log.info("Logged in successfully.");
    }
    public frozensPages navigateToFrozen(){
        return new frozensPages(WebDriverManager.initlaizeDriver());
    }
    public HomePage getHomePage() {
        log.info("Trying to access homepage.");
        return new HomePage(WebDriverManager.initlaizeDriver());
    }

    public String getEmail() throws Exception {
        String email = System.getenv("EMAIL");
        if( email == null){
            throw new Exception("You need to execute the Credentials file.");
        }

        return email;
    }

    public String getPassword() throws Exception {
        String password = System.getenv("PASSWORD");
        if( password == null){
            throw new Exception("You need to execute the Credentials file.");
        }
        return password;
    }
}

