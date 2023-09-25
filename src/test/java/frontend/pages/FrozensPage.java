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
            //saving the product price to assert later
//            WebElement priceElement = randomProduct.findElement(By.xpath(".//div[@data-v-49951636]//span[contains(@class, 'currency-wrap')]/span[1]"));
//            String productPrice = priceElement.getText();

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
        WebElement ulElement = driver.findElement(By.xpath("//ul[@data-v-46f5e6cc='']"));
        int ulSize = ulElement.findElements(By.tagName("li")).size();
        return ulSize;


    }

    public void sortFromCheapTo(int retry){
        int maxret = 0;
        while (maxret < retry) {
            waitTillVisible(driver,10,By.xpath("//div[@class='blue s-text mx-3 d-none d-lg-block']"));

                waitTillClickable(driver, 10, By.xpath("//div[@class='blue s-text mx-3 d-none d-lg-block']"));

                maxret++;
        }
        waitTillClickable(driver,10,By.xpath("//button[@aria-label='אפשרויות מיון וסינון, מיין לפי רלוונטיות']"));
        WebElement cheapest = waitTillVisible(driver,10,By.xpath("//li[@class='sort-list-item gray-hover border-radius-10 py-2 m-1']"));
        cheapest.click();

    }

    }







