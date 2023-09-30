package frontend.context;

import backend.HttpHelper;
import frontend.pages.FrozensPage;
import frontend.pages.HomePage;
import frontend.pages.SortedFrozenPage;
import frontend.utils.WebDriverManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestContext {
    private HomePage homePage;

    public void loginUi(String email, String password){
            HttpHelper.loginUi(WebDriverManager.initlaizeDriver(),email,password);
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
        log.info("Trying to access frozen page.");
        return new FrozensPage(WebDriverManager.initlaizeDriver());
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

