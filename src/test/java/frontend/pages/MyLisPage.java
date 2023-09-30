package frontend.pages;

import frontend.locators.MyListLocators;
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
        creatList = driver.findElement(MyListLocators.createList);
        actions = new Actions(driver);
    }

    public void openList() {
        waitTillClickable(driver, 10, MyListLocators.createList);
    }

    public void writeList(String[] list) {
        writingArea = driver.findElement(MyListLocators.productsList);
        waitTillVisible(driver, 10, MyListLocators.productsList);
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
            WebElement temp = writingArea.findElement(MyListLocators.contunie);
            temp.click();
            ret++;
        }

    }
    public void add(){

        List<WebElement> searchResultItems = driver.findElements(MyListLocators.results);
        WebElement itemToAdd = searchResultItems.get(0);

        WebElement addToCartButton = itemToAdd.findElement(MyListLocators.first);
        addToCartButton.click();

    }

    public void deletTheList() {
        cancleList = writingArea.findElement(MyListLocators.deleteList);
        cancleList.click();

        popupToDelet = writingArea.findElement(MyListLocators.popupDelet);
        waitTillVisible(driver,10,MyListLocators.popupDelet);

        confirmationTodelete= popupToDelet.findElement(MyListLocators.confirmationdelete);
        waitTillClickable(driver, 10, MyListLocators.confirmationdelete);
    }
}
