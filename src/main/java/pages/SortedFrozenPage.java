package pages;

import locators.FrozensPageLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class SortedFrozenPage extends basePage{
    private WebElement priceElement;
    private WebElement cart;
    private WebElement categoryElement;
    public SortedFrozenPage(WebDriver driver) {
        super(driver);
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

    public void addTheCheapestItem(){
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
        closeAD();
    }
    public void opencart() {

         cart = waitTillVisible(driver, 10, By.xpath("//div[@class='z-index-9 position-fixed bottom-5 w-95']"));
         try{
             if (cart != null) {
                 cart.click();
             }
             else{
                 System.out.println("its null.");
             }
         }catch (ElementClickInterceptedException e){
             System.out.println("element click intercepted.");
         }

    }
    public String checkTheCart(){
        priceElement =waitTillVisible(driver,10,By.xpath("//div[@data-v-a5d33fbe]//span[contains(@class, 'currency-wrap')]"));
        String priceText = priceElement.getText();

        return priceText;
    }
    private void closeAD(){
        try {
            waitTillClickable(driver,20, FrozensPageLocators.CLOSE_AD);
        }
        catch (Exception e){
            System.out.println("failed to close pop up.");
        }
    }

}
