package pages;

import locators.FrozensPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class FrozensPage extends basePage {
    private WebElement categoryElement;
    private WebElement modle;
    private WebElement closee;
    private WebElement remove;
    private WebElement confirm;
    private WebElement cart;
    private WebElement cartProducts;
    private WebElement products;
    private WebElement listproducts;



    private final String Url = "https://www.rami-levy.co.il/he/online/market/%D7%A7%D7%A4%D7%95%D7%90%D7%99%D7%9D";

    public FrozensPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void sortByCheapest(int num){
        super.sortByCheapest(3);
    }

    @Override
    public void addTheCheapestItem() {
        super.addTheCheapestItem();
    }

    @Override
    public String checkTheCart() {
        return super.checkTheCart();
    }
    @Override
    public void opencart() {
        super.opencart();
    }
    public void addItemsToCart(){
        Random random = new Random();
         categoryElement = waitTillVisible(driver, 10, By.xpath("//div[1]/div[2][@role='list']"));
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
        modle = waitTillVisible(driver, 10, By.id("delivery-modal"));
        WebElement close = modle.findElement(By.id("close-popup"));
        close.click();

    }

    public void close(){
        closee = waitTillVisible(driver, 10, By.id("close-popup"));
        if (closee != null) {
            closee.click();
        }
        System.out.println("null");
    }


    public int verifyCart(){
         cartProducts =waitTillVisible(driver,10,By.xpath("//div[@aria-label='סל קניות']"));
         products= waitTillVisible(driver,10,By.xpath("//div[@aria-label='רשימת מוצרים בעגלת קניות']"));
         listproducts = products.findElement(By.cssSelector("#market > ul"));
         int ulSize = listproducts.findElements(By.tagName("li")).size();
         return ulSize;
    }
    public String EmptyCart() {
        cart = waitTillVisible(driver, 30, By.xpath("//div[@class='z-index-9 position-fixed bottom-5 w-95']"));
        String pricenValue = cart.getText();
        return pricenValue;
    }

    public void removeCart(){
        close();
        waitTillClickable(driver,20, FrozensPageLocators.REMOVEBUTTONCART);
        waitTillClickable(driver,20, FrozensPageLocators.CONFIRMATION);
        waitTillVisible(driver,10, By.id("full-quick"));
    }

    }







