package frontend.pages;

import frontend.locators.MainPageLocators;
import frontend.locators.MyListLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends basePage {

        private final String Url = "https://www.rami-levy.co.il/he";

        private Actions actions;
        private  WebElement searchElemt;
        private WebElement gotoMain;
        private WebElement frozenss;
        private WebElement sort;
        private WebElement login;
        private String currentUrl;

        public HomePage(WebDriver driver) {
            super(driver);
            this.getUrl();
        }

        public void getUrl() {
            driver.get(Url);
            this.initPage();
        }

        public void initPage() {
            actions = new Actions(driver);
            login = waitTillVisible(driver,20,MainPageLocators.LOGINUSER);
        }


    public void searchStuff(String item) {
        WebElement searchElement = waitTillVisible(driver, 10, MainPageLocators.search);
        searchElement.sendKeys(item);
        searchElement.sendKeys(Keys.RETURN);

        // Wait for the page to load if necessary
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("search")); // You can customize this condition

        // Get the current URL after the page has loaded
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
    }

    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        return currentUrl;
    }
        public void returnToMain(){
            waitTillClickable(driver,10,MainPageLocators.mainPage);

        }

        public void goToFrozen(){
            waitTillClickable(driver,10,MainPageLocators.frozens);

        }
//        public void sortFromCheapTo(int retry){
//            int maxret = 0;
//
//            while (maxret < retry) {
//                try {
//                  WebElement web=  waitTillVisible(driver, 10, MainPageLocators.sorting);
//                  if(web !=null){
//                      break;
//                  }
//                 maxret++;
//
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//            }
        public String getLogin(){
            return login.getText();
        }

        public void refresh(){
            this.refreshBrowser();
        }
        public void close(){
            this.closeBrowser();
        }
}
