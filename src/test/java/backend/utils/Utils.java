package backend.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
@Slf4j
public class Utils {
    private static JavascriptExecutor js;
    public static  HashMap<String,String> getUserNameMap(String email,String password){
        HashMap<String,String> userDet = new HashMap<>();
        userDet.put("username",email);
        userDet.put("password",password);
        return  userDet;
    }
    public static void waitTillScriptExecuted(WebDriver driver, int timeout, String script) {
         js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

       wait.until(webDriver -> {
            try {
                js.executeScript(script);
                return true;
            } catch (Exception e) {
                log.error("couldn't execute the script\nreason:" + e);
                return false;
            }
        });
    }

    public static void waitTillScriptExecutedStringFormat(WebDriver driver, int timeout, String json, int maxRetries) {
         js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        String script = "window.localStorage.setItem('ramilevy', JSON.stringify(" + json + "));";

        int retryCount = 0;
        boolean scriptExecuted = false;

        while (retryCount < maxRetries && !scriptExecuted) {
            try {
                scriptExecuted = wait.until(webDriver -> {
                    try {
                        js.executeScript(script);
                        return true;
                    } catch (Exception e) {
                        log.error("couldn't execute the script\nreason:"+e);
                        return false;
                    }
                });
            } catch (TimeoutException e) {
                log.error("Timeout Exception");
            }

            if (!scriptExecuted) {
                retryCount++;
                log.info("Retrying script execution (Attempt " + retryCount + ")");
            }
        }

        if (!scriptExecuted) {
            log.error("Script execution failed after " + maxRetries + " retries.");
        }
        if (scriptExecuted) log.info("suceffully exectued the script.");
    }



}
