package backend.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class Utils {
    public static  HashMap<String,String> getUserNameMap(String email,String password){
        HashMap<String,String> userDet = new HashMap<>();
        userDet.put("username",email);
        userDet.put("password",password);
        return  userDet;
    }
    public static void waitTillScriptExecuted(WebDriver driver, int timeout, String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(webDriver -> (Boolean) js.executeScript(script));
    }
}
