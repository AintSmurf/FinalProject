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

public class HomePage extends basePage {
    private final String Url = "https://www.rami-levy.co.il/he";

    private Actions actions;

    private  WebElement searchElemt;

    private WebElement gotoMain;
    private WebElement frozenss;
    private WebElement sort;

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

    }


    public void searchstuff(String item){
        searchElemt= driver.findElement(MainPageLocators.search);
        searchElemt.sendKeys(item);
        searchElemt.sendKeys(Keys.RETURN);

    }
    public void returnToMain(){
        gotoMain = driver.findElement(MainPageLocators.mainPage);
        gotoMain.click();
    }

    public void goToFrozen(){
        frozenss = driver.findElement(MainPageLocators.frozens);
        frozenss.click();
    }
    public void sortFromCheapTo(){
        sort = driver.findElement(MainPageLocators.sorting);
        sort.click();
    }

    public void refresh(){
        this.refreshBrowser();
    }
    public void close(){
        this.closeBrowser();
    }
}
