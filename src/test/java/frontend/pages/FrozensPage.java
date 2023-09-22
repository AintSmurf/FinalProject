package frontend.pages;

import frontend.locators.MainPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class FrozensPage extends basePage {
    private WebElement cartItems;
    private WebElement close;
    private WebElement add;
    private WebElement list;

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
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,2500)");

    }

    public void addItemsToCart() throws InterruptedException {

        Random random = new Random();
        WebElement categoryElement = waitTillVisible(driver, 10, By.xpath("//div[1]/div[2][@role='list']"));
        List<WebElement> productElements = categoryElement.findElements(By.xpath("//div[starts-with(@id, 'min-height-product-')]"));

        if (!productElements.isEmpty()) {
            int randomIndex = random.nextInt(productElements.size());
            WebElement randomProduct = productElements.get(randomIndex);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomProduct);

            Actions action = new Actions(driver);
            action.moveToElement(randomProduct).build().perform();


            randomProduct.click();
            waitTillVisible(driver, 10, By.xpath("//button[@class='focus-item btn-acc plus no-select']")).click();
        }

        WebElement modle = waitTillVisible(driver, 10, By.id("delivery-modal"));
        System.out.println(modle);
        WebElement close = modle.findElement(By.id("close-popup"));
        close.click();
    }

    public void close() throws InterruptedException {

        WebElement closee = waitTillVisible(driver, 10, By.id("close-popup"));
        if (closee != null) {
            closee.click();
        }
        System.out.println("nulli");

    }

    public void opencart() {
        WebElement cart = waitTillVisible(driver, 10, By.xpath("//div[@class='z-index-9 position-fixed bottom-5 w-95']"));
        if (cart != null) {
            cart.click();
        }
        System.out.println("null");

    }


    public int verfyCart() throws InterruptedException {


        WebElement elements = driver.findElement(By.xpath("//div[@aria-label='1 פריטים בסל. לחץ לפירוט']"));
        elements.click();
Thread.sleep(3000);
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inner-scroll rl-scroll']"));
          waitTillVisible(driver,10,By.xpath("//div[@class='inner-scroll rl-scroll']"));
          return items.size();


    }

    public void sortFromCheapTo(int retry){
        int maxret = 0;

        while (maxret < retry) {
            try {
                WebElement web=  waitTillVisible(driver, 10, By.xpath("//div[@class='blue s-text mx-3 d-none d-lg-block']"));
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




