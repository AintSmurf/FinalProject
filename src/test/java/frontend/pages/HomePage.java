package frontend.pages;

import frontend.locators.MyListLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class HomePage extends basePage {
    private final String Url = "https://www.rami-levy.co.il/he";
    private WebElement creatList;
    private WebElement writingArea;
    private Actions actions;
    private WebElement contunie;
    private WebElement delete;

    public HomePage(WebDriver driver) {
        super(driver);
        this.getUrl();
    }

    public void getUrl() {
        driver.get(Url);
        this.initPage();
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
          WebElement web = driver.findElement(MyListLocators.listItems);
          List<WebElement>elements = web.findElements(By.tagName("div"));
        for (WebElement w: elements
             ) {
            System.out.println(w.getText());

        }


    }

    public void cancle1(int ret) {
        int maxret = 0;
        while (maxret < ret) {
            WebElement cancle = writingArea.findElement(MyListLocators.deleteList);
            cancle.click();
            ret++;

        }

    }
}
