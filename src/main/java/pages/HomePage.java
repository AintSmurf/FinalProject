package pages;

import locators.HomePageLocators;
import locators.QuickPurchaseLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends basePage {
    private final String Url = "https://www.rami-levy.co.il/he";
    private WebElement writingArea;
    private Actions actions;
    private WebElement cancelList;
    private WebElement listBack;
    private WebElement finishButton;
    private WebElement searchResultItems;
    private WebElement quikpurchesTap;
    private WebElement contunie;
    private WebElement textarea;
    private WebElement productNameElement;
    private WebElement listproducts;

    private WebElement searchElemt;
    private WebElement gotoMain;
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
        login = waitTillVisible(driver, 20, HomePageLocators.LOGINUSER);
    }

    public void login(String user, String password) {
        login = driver.findElement(HomePageLocators.LOGIN);
        WebElement temp = waitTillClickable(driver, 10, login);
        temp.click();

        driver.findElement(HomePageLocators.USERINPUT).sendKeys(user);
        driver.findElement(HomePageLocators.PASSWORD).sendKeys(password);
        waitTillClickable(driver, 10, HomePageLocators.LOGINButton);
        driver.navigate().refresh();
    }


    public void searchStuff(String item) {
        searchElemt = driver.findElement(HomePageLocators.SEARCH);
        searchElemt.sendKeys(item);
        searchElemt.sendKeys(Keys.RETURN);

    }

    public void returnToMain() {
        gotoMain = driver.findElement(HomePageLocators.MAIN_PAGE);
        gotoMain.click();
    }

    public FrozensPage NavigateToFrozen() {
        waitTillClickable(driver, 20, HomePageLocators.FROZENS);
        return new FrozensPage(driver);
    }

    public void NavigateToFruits() {
        waitTillClickable(driver, 20, HomePageLocators.FRUITS);
    }

    public void NavigateToDairy() {
        waitTillClickable(driver, 20, HomePageLocators.DAIRY);
    }

    public void NavigateToOrganic() {
        waitTillClickable(driver, 20, HomePageLocators.ORGANIC);
    }

    public void NavigateToBaking() {
        waitTillClickable(driver, 20, HomePageLocators.BAKING);
    }

    public void sortFromCheapTo() {
        waitTillClickable(driver, 20, HomePageLocators.SORTING);
    }

    public String getSearchKeyword() {
        WebElement webElement = waitTillVisiblee(driver, 20, HomePageLocators.SEARCHKEYWORD);
        return webElement.getText();
    }


    public void openFastPurchase() {
        quikpurchesTap = waitTillVisible(driver, 10, QuickPurchaseLocators.CREATE_LIST);
        quikpurchesTap.click();
    }

    // writing into the quick purchase list
    public void writeList(List<String> list) {
        writingArea = waitTillVisible(driver, 10, QuickPurchaseLocators.PRODUCT_LIST);
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

    // click on המשך after writing the products
    public void Continue(int ret) throws InterruptedException {
        int maxret = 0;
        while (maxret < ret) {
            contunie = writingArea.findElement(QuickPurchaseLocators.CONTUNIE);
            contunie.click();
            if (contunie != null) {
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
                waitTillClickable(driver, 10, By.xpath("//div[@aria-label='הבא']"));

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
            searchResultItems = waitTillVisible(driver, 10, QuickPurchaseLocators.RESULTS);
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
        finishButton = driver.findElement(QuickPurchaseLocators.FINISHED);

        if (finishButton != null) {
            waitTillClickable(driver, 10, QuickPurchaseLocators.FINISHED);
        } else {
            System.out.println("Finish button not found");
        }
    }

    public void deleteTheList() {

        cancelList = waitTillVisible(driver, 10, QuickPurchaseLocators.DELET_LIST);
        cancelList.click();

        waitTillVisible(driver, 10, QuickPurchaseLocators.POPUP_DELETE);

        waitTillClickable(driver, 10, QuickPurchaseLocators.CONFIRM_DELETE);
    }

    public void backtoList() {
        listBack = driver.findElement(QuickPurchaseLocators.GO_TO_LIST);
        listBack.click();
    }

    public boolean checkIfTheListEmpty() {
        textarea = driver.findElement(By.id("list-product"));
        String valuein = textarea.getAttribute("value");
        if (valuein.isEmpty() == true) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<String> verifyProductInTheCart() {
        ArrayList<String> names = new ArrayList<>();
        WebElement products = waitTillVisible(driver, 10, By.xpath("//div[@aria-label='רשימת מוצרים בעגלת קניות']"));

        listproducts = products.findElement(By.cssSelector("#market > ul"));
        List<WebElement> listofProducts = listproducts.findElements(By.tagName("li"));
        for (WebElement oneProduct : listofProducts) {

            productNameElement = oneProduct.findElement(By.cssSelector("div.item-name"));
            String productName = productNameElement.getText();
            names.add(productName);
        }
        return names;

    }
    @Override
    public String checkTheCart() {
        return super.checkTheCart();
    }
    @Override
    public void opencart() {
        super.opencart();
    }
    @Override
    public void removeCart(){
        super.removeCart();
    }

    public String getLogin() {
        return login.getText();
    }
}
