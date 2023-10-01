package pages;

import locators.FrozensPageLocators;
import locators.basePageLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class basePage {

    protected WebDriver driver;
    private WebElement cart;
    private WebElement categoryElement;
    private Actions actions;

    public basePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }
        public static void waitTillClickable(WebDriver driver, int timeout, By value) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
                wait.until(ExpectedConditions.elementToBeClickable(value)).click();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        public static WebElement waitTillClickable(WebDriver driver, int timeout, WebElement w) {
            WebElement webElement = null;
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
                webElement = wait.until(ExpectedConditions.elementToBeClickable(w));

            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            return webElement;
        }

        public static WebElement waitTillVisible(WebDriver driver, int timeout, By value) {
            WebElement element = null;
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
                element= wait.until(ExpectedConditions.visibilityOfElementLocated(value));
            } catch (TimeoutException e) {
                System.out.println("couldnt find it");
            }
            return element;
        }
        public static WebElement waitTillVisiblee(WebDriver driver, int timeout, By value) {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofMillis(10))
                    .ignoring(Exception.class);

            WebElement headers = wait.until(d -> {
                WebElement element = d.findElement(value);
                element = waitTillClickable(driver,timeout,element);
                return element;
            });

            if (headers != null) {
                return headers;
            } else {
                throw new NoSuchElementException("Element not found or not enabled within the specified timeout.");
            }
        }


        public static boolean waitTillContainsText(WebDriver driver, int timeout, By value, String text) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
                wait.until(ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(value),
                        ExpectedConditions.textToBePresentInElementLocated(value, text)
                ));
                return true;
            } catch (TimeoutException e) {
                return false;
            }
        }

        public static boolean waitTillSelected(WebDriver driver, int timeout, By value) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
                wait.until(ExpectedConditions.elementToBeSelected(value));
                return true;
            } catch (TimeoutException e) {
                return false;
            }
        }
    protected void sortByCheapest(int retry){
        int maxret = 0;
        while (maxret < retry) {
            waitTillVisible(driver,10, basePageLocators.SORTICON);
            waitTillClickable(driver, 10,basePageLocators.SORTICON);
            maxret++;
        }
        waitTillClickable(driver,10, basePageLocators.SORTOPTIONS);
        WebElement cheapest = waitTillVisible(driver,10,basePageLocators.SORTBYCHEAPEST);
        cheapest.click();
    }
    public void addTheCheapestItem(){
        closeAD();
        categoryElement = waitTillVisible(driver, 10, basePageLocators.AFTERSORTLIST);
        List<WebElement> productElements = categoryElement.findElements(basePageLocators.CHEAPESTITEMONTHELIST);

        if (!productElements.isEmpty()) {
            WebElement firstProduct = productElements.get(0);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);

            Actions action = new Actions(driver);
            action.moveToElement(firstProduct).build().perform();

            firstProduct.click();
            waitTillVisible(driver, 10, basePageLocators.ADDBUTTON).click();
        }
        closeAD();
    }

    public void opencart() {
        cart = waitTillVisible(driver, 10, basePageLocators.CART);
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
        closeAD();
        WebElement webElement = waitTillVisible(driver, 20, basePageLocators.SCROLL);
        return  webElement.getText();
    }
    private void closeAD(){
        try {
            waitTillClickable(driver,20, FrozensPageLocators.CLOSE_AD);
        }
        catch (Exception e){
            System.out.println("failed to close pop up.");
        }
    }
    public void removeCart(){
        closeAD();
        waitTillClickable(driver,20, FrozensPageLocators.REMOVEBUTTONCART);
        waitTillClickable(driver,20, FrozensPageLocators.CONFIRMATION);
        waitTillVisible(driver,10, basePageLocators.ELEMNTTOCHECKTHEEMPTY);
    }

}



