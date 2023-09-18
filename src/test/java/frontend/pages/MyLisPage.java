package frontend.pages;

import frontend.locators.MyListLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MyLisPage extends basePage {
    private final String Url = "https://www.rami-levy.co.il/he";
    private WebElement creatList;
    private WebElement writingArea;
    private Actions actions;

    private WebElement cancleList;
    private WebElement popupToDelet;
    private WebElement confirmationTodelete;

    public MyLisPage(WebDriver driver) {
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
            if(temp!=null){
                break;
            }
            ret++;
        }

    }

//    public void Next(int ret) {
//        int maxret = 0;
//        while (maxret < ret) {
//
//            WebElement nex = driver.findElement(By.xpath("//div[@aria-label='הבא']"));
//            waitTillVisible(driver,10,By.xpath("//div[@aria-label='הבא']"));
//            nex.click();
//            if (nex != null) {
//                break;
//            }
//            ret++;
//        }
//    }
public void Next(int ret) {
    int maxret = 0;

    while (maxret < ret) {
        try {
            waitTillClickable(driver,10,By.xpath("//div[@aria-label='הבא']"));

            break;
        } catch (Exception e) {
            System.out.println("Element not found ");
        }
        maxret++;
    }
}


    public void add(int retry, int amount) throws InterruptedException {
        int ret = 0;
        int count = 0;
        while (ret < retry) {
            WebElement searchResultItems = waitTillVisible(driver, 10, MyListLocators.results);
            System.out.println(searchResultItems);
            List<WebElement> elements = searchResultItems.findElements(By.xpath("//div[@class='product-gallery-wrap flex-row-50 big-plus-minus item-card position-relative is-buy-list']"));
            List<WebElement> buttons = new ArrayList<>();
            for (int i = 0; i < elements.size(); i++) {
                if (count == amount) {
                    break;
                }
                buttons.add(elements.get(i).findElement(By.tagName("button")));
                count++;
            }
            for (WebElement button : buttons) {
                button.findElement(By.tagName("button")).click();
                try {
                    WebElement modle = waitTillVisible(driver, 10, By.id("delivery-modal"));
                    System.out.println(modle);
                    WebElement close = modle.findElement(By.id("close-popup"));
                    close.click();
                } catch (Exception e) {
                    System.out.println("failed to close");
                }
            }

            Next(1);
            count = 0;
            ret++;
        }
    }

    public void finishTheList() {
        WebElement finishButton = driver.findElement(By.xpath("//div[@aria-label='סיימתי, בלחיצה על כפתור זה המוצרים יתווספו לסל']"));

        if (finishButton != null) {
            waitTillClickable(driver,10,By.xpath("//div[@aria-label='סיימתי, בלחיצה על כפתור זה המוצרים יתווספו לסל']"));
        } else {
            System.out.println("Finish button not found");
        }
    }





        public void deletTheList () {
            cancleList = writingArea.findElement(MyListLocators.deleteList);
            cancleList.click();

            popupToDelet = writingArea.findElement(MyListLocators.popupDelet);
            waitTillVisible(driver, 10, MyListLocators.popupDelet);

            confirmationTodelete = popupToDelet.findElement(MyListLocators.confirmationdelete);
            waitTillClickable(driver, 10, MyListLocators.confirmationdelete);
        }

    }

