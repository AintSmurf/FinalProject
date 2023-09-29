package frontend.pages;

import frontend.locators.MainPageLocators;
import frontend.locators.QuieckPurchesLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends basePage {
    private WebElement writingArea;
    private Actions actions;

    private WebElement cancleList;
    private WebElement listBack;
    private WebElement finishButton;
    private WebElement searchResultItems;
    private WebElement quikpurchesTap;
    private WebElement contunie;
    private  WebElement textarea;
    private WebElement productNameElement;
    private WebElement listproducts;

    private final String Url = "https://www.rami-levy.co.il/he";

        private WebElement login;


        public HomePage(WebDriver driver) {
            super(driver);
            this.getUrl();
        }

        public void getUrl() {
            driver.get(Url);
            this.initPage();
        }

        public void initPage() {
            actions = new Actions(driver);
            login = waitTillVisible(driver,20,MainPageLocators.LOGINUSER);
        }


    public void searchStuff(String item) {
        WebElement searchElement = waitTillVisible(driver, 10, MainPageLocators.search);
        searchElement.sendKeys(item);
        searchElement.sendKeys(Keys.RETURN);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("search"));


        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
    }

    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        return currentUrl;
    }


//public void gotoCheckOut() {
//
//    WebElement v = waitTillVisible(driver, 20, By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div[2]"));
//    v.click();
//
//}
    public void openFastPurches() {
        quikpurchesTap = waitTillVisible(driver, 10, QuieckPurchesLocators.createList);
        quikpurchesTap.click();
    }


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
            contunie = writingArea.findElement(QuieckPurchesLocators.contunie);
            contunie.click();
            if(contunie!=null){
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
         textarea = driver.findElement(By.id("list-product"));
        String valuein = textarea.getAttribute("value");
        if (valuein.isEmpty()==true) {
            return true;
        }
        else {
            return false;
        }

    }
    public ArrayList<String> verifyProductInTheCart(){
       ArrayList<String> names = new ArrayList<>();
        WebElement cartProducts =waitTillVisible(driver,10,By.xpath("//div[@aria-label='סל קניות']"));
        WebElement products= waitTillVisible(driver,10,By.xpath("//div[@aria-label='רשימת מוצרים בעגלת קניות']"));

         listproducts = products.findElement(By.cssSelector("#market > ul"));
        List<WebElement> listofTheeachProduct = listproducts.findElements(By.tagName("li"));
        for (WebElement oneProduct: listofTheeachProduct) {

             productNameElement = oneProduct.findElement(By.cssSelector("div.item-name"));
            String productName = productNameElement.getText();
            names.add(productName);


        }
        return names;

    }

    public  void login(String user, String password) {
        login =driver.findElement(MainPageLocators.login);
        WebElement temp=waitTillClickable(driver,10,login);
        temp.click();

        driver.findElement(MainPageLocators.USERINPUT).sendKeys(user);
        driver.findElement(MainPageLocators.PASSWORD).sendKeys(password);
        waitTillClickable(driver,10,MainPageLocators.LOGINButton);
        driver.navigate().refresh();
        System.out.println(getLogin());

    }

    public String getLogin(){
            return login.getText();
        }

        public void refresh(){
            this.refreshBrowser();
        }
        public void close(){
            this.closeBrowser();
        }
}
