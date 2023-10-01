package pages;

import locators.FrozensPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class FrozensPage extends basePage {
    private WebElement categoryElement;
    private WebElement modle;
    private WebElement closee;
    private WebElement remove;
    private WebElement confirm;
    private WebElement cart;
    private WebElement cartProducts;
    private WebElement products;
    private WebElement listproducts;
    private WebElement close;



    private final String Url = "https://www.rami-levy.co.il/he/online/market/%D7%A7%D7%A4%D7%95%D7%90%D7%99%D7%9D";

    public FrozensPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void sortByCheapest(int num){
        super.sortByCheapest(3);
    }

    @Override
    public void addTheCheapestItem() {
        super.addTheCheapestItem();
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
    public void addItemsToCart(){
        Random random = new Random();
         categoryElement = waitTillVisible(driver, 10, FrozensPageLocators.CATAGORY);
        List<WebElement> productElements = categoryElement.findElements(FrozensPageLocators.PRODUCTS);

        if (!productElements.isEmpty()) {
            int randomIndex = random.nextInt(productElements.size());
            WebElement randomProduct = productElements.get(randomIndex);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomProduct);

            Actions action = new Actions(driver);
            action.moveToElement(randomProduct).build().perform();


            randomProduct.click();

            waitTillVisible(driver, 10,FrozensPageLocators.ADDBUTTON).click();
        }
        modle = waitTillVisible(driver, 10, FrozensPageLocators.DELEVIRYMODELE);
         close = modle.findElement(FrozensPageLocators.CLOSEMODELE);
        close.click();

    }

    public void close(){
        closee = waitTillVisible(driver, 10, FrozensPageLocators.CLOSEPOPUP);
        if (closee != null) {
            closee.click();
        }
        System.out.println("null");
    }


    public int verifyCart(){
         cartProducts =waitTillVisible(driver,10,FrozensPageLocators.CARTPRODUCT);
         products= waitTillVisible(driver,10,FrozensPageLocators.LISTPRODUCTS);
         listproducts = products.findElement(FrozensPageLocators.PRODUCTONTHELIST);
         int ulSize = listproducts.findElements(By.tagName("li")).size();
         return ulSize;
    }
    public String EmptyCart() {
        cart = waitTillVisible(driver, 30, FrozensPageLocators.CARTELEMENT);
        String pricenValue = cart.getText();
        return pricenValue;
    }



    }







