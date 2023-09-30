package frontend.pages;

import frontend.locators.MainPageLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class basePage {

    protected WebDriver driver;
    List<WebElement> addButtons;
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
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(value));
        } catch (TimeoutException e) {
            System.out.println("couldnt find it");
        }
        return element;
    }

    public static List<WebElement> waitTillAllVisible(WebDriver driver, int timeout, By value) {
        List<WebElement> elements = new ArrayList<>();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(value));
        } catch (TimeoutException e) {
            System.out.println("couldnt find it");
        }
        return elements;
    }

    public static WebElement waitTillVisiblee(WebDriver driver, int timeout, By value) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(10))
                .ignoring(Exception.class);

        WebElement headers = wait.until(d -> {
            WebElement element = d.findElement(value);
            element = waitTillClickable(driver, timeout, element);
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

    protected void refreshBrowser() {
        driver.navigate().refresh();
    }

    protected void closeBrowser() {
        driver.close();
    }
}


