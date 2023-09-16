package frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class frozensPage extends basePage {
    private WebElement clicktopay;
    private final String Url = "https://www.rami-levy.co.il/he/online/market/%D7%A7%D7%A4%D7%95%D7%90%D7%99%D7%9D";

    public frozensPage(WebDriver driver) {
        super(driver);
        this.getUrl();
    }

    public void getUrl() {
        driver.get(Url);
        this.initPage();
    }

    public void initPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

    }

    public void additem() {
        WebElement web = driver.findElement(By.xpath("//div[1]/div[2][@role='list']"));

        WebElement first = web.findElement(By.id("min-height-product-0"));
        waitTillVisible(driver,10,By.id("min-height-product-0"));

        Actions action = new Actions(driver);
        action.moveToElement(first).build().perform();

        WebElement add = driver.findElement( By.id("Capa_1"));
        waitTillVisible(driver,10, By.id("Capa_1"));
        add.click();

        waitTillVisible(driver,10, By.id("delivery-modal___BV_modal_body_"));
        WebElement close = driver.findElement(By.id("close-popup"));
        close.click();
    }

    public void goToVhrckOut() {
        clicktopay = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div[2]"));
        clicktopay.click();
    }
    public void verfyCart(){
        WebElement cartItems = driver.findElement(By.xpath("//div[@aria-label='2 פריטים בסל. לחץ לפירוט']"));
        if(cartItems.isDisplayed()){
            WebElement payment = driver.findElement(By.id("paymentBtn"));


        }
    }
}




