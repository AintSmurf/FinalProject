package frontend.pages;

import frontend.locators.QuieckPurchesLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuiekPurchesPage extends basePage {
    private final String Url = "https://www.rami-levy.co.il/he";
    private WebElement creatList;
    private WebElement writingArea;
    private Actions actions;

    private WebElement cancleList;
    private WebElement listBack;
    private WebElement finishButton;
    private WebElement searchResultItems;

    private WebElement popupToDelet;
    private WebElement confirmationTodelete;


    public QuiekPurchesPage(WebDriver driver) {
        super(driver);
        this.getUrl();
    }

    public void getUrl() {
        driver.get(Url);
        this.initPage();
    }

    public void initPage() {
        creatList = driver.findElement(QuieckPurchesLocators.createList);
        actions = new Actions(driver);
    }


//    public void openFastPurches() {
//            WebElement quik = waitTillVisible(driver, 10, QuieckPurchesLocators.createList);
//            quik.click();
//
//   }



// writing on the quiech purches list
    public void writeList(List<String> list) {
      writingArea = waitTillVisible(driver, 10, QuieckPurchesLocators.productsList);
//       waitTillClickable(driver,10,writingArea);
        for (int i = 0; i < list.size(); i++) {
            actions.sendKeys(writingArea, list.get(i)).build().perform();
            this.newline();
        }
    }
//new line for each word on the list
    public void newline() {
        actions.keyDown(Keys.SHIFT).sendKeys(writingArea, Keys.ENTER).keyUp(Keys.SHIFT).build().perform();
    }
// click on המשך after writting the prducts
    public void Contunie(int ret) throws InterruptedException {
        int maxret = 0;
        while (maxret < ret) {
            WebElement temp = writingArea.findElement(QuieckPurchesLocators.contunie);
            temp.click();
            if(temp!=null){
                break;
            }
            ret++;
        }

    }

// click on הבא
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
             searchResultItems = waitTillVisible(driver, 10, QuieckPurchesLocators.results);
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
         finishButton = driver.findElement(QuieckPurchesLocators.finished);

        if (finishButton != null) {
            waitTillClickable(driver,10,QuieckPurchesLocators.finished);
        } else {
            System.out.println("Finish button not found");
        }
    }
        public void deletTheList () {

            cancleList =waitTillVisible(driver,10, QuieckPurchesLocators.deleteList);
            cancleList.click();

          waitTillVisible(driver, 10, QuieckPurchesLocators.popupDelet);

            waitTillClickable(driver, 10, QuieckPurchesLocators.confirmationdelete);
        }

        public void backtoList(){
        listBack = driver.findElement(QuieckPurchesLocators.goTolist);
        listBack.click();
        }
        public boolean checkIfTheListEmpty(){
            WebElement textarea = driver.findElement(By.id("list-product"));
            String valuein = textarea.getAttribute("value");
         if (valuein.isEmpty()==true) {
             return true;
         }
         else {
            return false;
         }

        }

    public void close(){
        this.closeBrowser();
    }

}

