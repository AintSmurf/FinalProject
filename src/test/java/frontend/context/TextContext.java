package frontend.context;

import backend.HttpHelper;
import frontend.pages.FrozensPage;
import frontend.pages.HomePage;
import frontend.pages.QuiekPurchesPage;
import frontend.pages.SortedFrozenPage;
import frontend.utils.WebDriverManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
public class TextContext {
    private HomePage homePage;

    public void login(String email, String password) throws URISyntaxException, IOException, InterruptedException {
        int ret = 0;
        while (ret < 10) {
            HttpHelper.login(WebDriverManager.initlaizeDriver(), email, password);
            if (this.getHomePage().getLogin() != null) {
                break;
            } else {
                log.error("failed to execute the script.");
                ret++;
            }
        }
        log.info("Logged in successfully.");
    }

    public HomePage getHomePage() {
        log.info("Trying to access homepage.");
        if (homePage == null) {
            homePage = new HomePage(WebDriverManager.initlaizeDriver());
        }
        return homePage;
    }

    public FrozensPage getFrozen() {
        log.info("trying to go to frozen");
        return new FrozensPage(WebDriverManager.initlaizeDriver());
    }

    public QuiekPurchesPage myList() {
        log.info("trying to ceate list of products");
        return new QuiekPurchesPage(WebDriverManager.initlaizeDriver());
    }
    public SortedFrozenPage sorted(){
        return new SortedFrozenPage(WebDriverManager.initlaizeDriver());
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

