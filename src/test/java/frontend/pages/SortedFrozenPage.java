package frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class SortedFrozenPage extends basePage{
    private WebElement priceElement;
    private WebElement cart;
    private WebElement categoryElement;
    public SortedFrozenPage(WebDriver driver) {
        super(driver);
    }

    public void addTheCheapestItem() throws InterruptedException {
         categoryElement = waitTillVisible(driver, 10, By.xpath("//div[1]/div[2][@role='list']"));
        List<WebElement> productElements = categoryElement.findElements(By.xpath("//div[starts-with(@id, 'min-height-product-')]"));

        if (!productElements.isEmpty()) {
            WebElement firstProduct = productElements.get(0);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);

            Actions action = new Actions(driver);
            action.moveToElement(firstProduct).build().perform();

            firstProduct.click();
            waitTillVisible(driver, 10, By.xpath("//button[@class='focus-item btn-acc plus no-select']")).click();
        }

        WebElement modle = waitTillVisible(driver, 10, By.id("delivery-modal"));
        System.out.println(modle);
        WebElement closeT = modle.findElement(By.id("close-popup"));
        closeT.click();

    }
    public void opencart() {
         cart = waitTillVisible(driver, 10, By.xpath("//div[@class='z-index-9 position-fixed bottom-5 w-95']"));
        if (cart != null) {
            cart.click();
        }
        System.out.println("null");

    }
    public String checkTheCart(){
         priceElement =waitTillVisible(driver,10,By.xpath("//div[@data-v-a5d33fbe]//span[contains(@class, 'currency-wrap')]"));
        String priceText = priceElement.getText();

        return priceText;
    }

}
