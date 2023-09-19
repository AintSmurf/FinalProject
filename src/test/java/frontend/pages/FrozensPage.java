package frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FrozensPage extends basePage {
    private  WebElement cartItems;
    private  WebElement close;
    private WebElement add;
    private  WebElement list;

    private WebElement clicktopay;
    private final String Url = "https://www.rami-levy.co.il/he/online/market/%D7%A7%D7%A4%D7%95%D7%90%D7%99%D7%9D";

    public FrozensPage(WebDriver driver) {
        super(driver);
        driver.navigate().to(Url);

    }

    public void Navigate() {
        driver.get(Url);
        this.initPage();
    }

    public void initPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2500)");

    }

    public void additem() {

            list = driver.findElement(By.xpath("//div[1]/div[2][@role='list']"));
            waitTillVisible(driver,10,By.xpath("//div[1]/div[2][@role='list']"));

        List<WebElement> elementsWithSameId = driver.findElements(By.id("min-height-product-0"));
        waitTillVisible(driver,10,By.id("min-height-product-0"));

        if (!elementsWithSameId.isEmpty()) {
            WebElement firstElement = elementsWithSameId.get(0);

            Actions action = new Actions(driver);
            action.moveToElement(firstElement).build().perform();

            add = driver.findElement(By.xpath("//svg[@id='Capa_1']"));
            waitTillVisible(driver, 10, By.xpath("//svg[@id='Capa_1']"));
            add.click();
        }

        waitTillVisible(driver,10, By.id("delivery-modal___BV_modal_body_"));
         close = driver.findElement(By.id("close-popup"));
        close.click();
    }

    public void goToVhrckOut() {
        waitTillClickable(driver,10,By.className("focus-item d-flex- white-text w-100 px-3- pl-md-5"));
    }
    public void verfyCart(){
          cartItems = driver.findElement(By.xpath("//div[@aria-label='1 פריטים בסל. לחץ לפירוט']"));
          if(cartItems.isDisplayed()){
            WebElement payment = driver.findElement(By.id("paymentBtn"));


        }
    }
    public void sortFromCheapTo(int retry){
        int maxret = 0;

        while (maxret < retry) {
            try {
                WebElement web=  waitTillVisible(driver, 10, By.className("blue s-text mx-3 d-none d-lg-block"));
                web.click();
                if(web !=null){
                    break;
                }
                maxret++;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}




