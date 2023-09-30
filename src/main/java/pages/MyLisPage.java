package pages;

import locators.QuickPurchaseLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MyLisPage extends basePage {
    private WebElement creatList;
    private WebElement writingArea;
    private Actions actions;

    private WebElement cancleList;
    private WebElement popupToDelet;
    private WebElement confirmationTodelete;

    public MyLisPage(WebDriver driver) {
        super(driver);
    }


    public void initPage() {
        creatList = driver.findElement(QuickPurchaseLocators.CREATE_LIST);
        actions = new Actions(driver);
    }

    public void openList() {
        waitTillClickable(driver, 10, QuickPurchaseLocators.CREATE_LIST);
    }

    public void writeList(String[] list) {
        writingArea = driver.findElement(QuickPurchaseLocators.PRODUCT_LIST);
        waitTillVisible(driver, 10, QuickPurchaseLocators.PRODUCT_LIST);
        for (int i = 0; i < list.length; i++) {
            actions.sendKeys(writingArea, list[i]).build().perform();
            this.newline();
        }
    }

    public void newline() {
        actions.keyDown(Keys.SHIFT).sendKeys(writingArea, Keys.ENTER).keyUp(Keys.SHIFT).build().perform();
    }

    public void Contunie(int ret) throws InterruptedException {
        int maxret = 0;
        while (maxret < ret) {
            WebElement temp = writingArea.findElement(QuickPurchaseLocators.CONTUNIE);
            temp.click();
            ret++;
        }

    }
    public void add(){

        List<WebElement> searchResultItems = driver.findElements(QuickPurchaseLocators.RESULTS);
        WebElement itemToAdd = searchResultItems.get(0);

        WebElement addToCartButton = itemToAdd.findElement(QuickPurchaseLocators.FIRST);
        addToCartButton.click();

    }

    public void deletTheList() {
        cancleList = writingArea.findElement(QuickPurchaseLocators.DELET_LIST);
        cancleList.click();

        popupToDelet = writingArea.findElement(QuickPurchaseLocators.POPUP_DELETE);
        waitTillVisible(driver,10,QuickPurchaseLocators.POPUP_DELETE);

        confirmationTodelete= popupToDelet.findElement(QuickPurchaseLocators.CONFIRM_DELETE);
        waitTillClickable(driver, 10, QuickPurchaseLocators.CONFIRM_DELETE);
    }
}
