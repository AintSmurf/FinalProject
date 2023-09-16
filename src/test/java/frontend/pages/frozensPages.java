package frontend.pages;

import frontend.locators.MyListLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class frozensPages extends basePage{
    private final String Url = "https://www.rami-levy.co.il/he/online/market/%D7%A7%D7%A4%D7%95%D7%90%D7%99%D7%9D";

    public frozensPages(WebDriver driver) {
        super(driver);
        this.getUrl();
    }

    public void getUrl() {
        driver.get(Url);
        this.initPage();
    }

    public void initPage() {

    }

    public void additem(){

    }

}
