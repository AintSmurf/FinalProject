package locators;

import org.openqa.selenium.By;

public class FrozensPageLocators {
    public static By TO_PAY =By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div[2]");
    public static By LISTFROZENS= By.xpath("//div[1]/div[2][@role='list']");
    public static By ADD_ITEM =  By.id("Capa_1");
    public static By CLOSE_AD=By.id("close-popup");
    public static By CLICKONCART=By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div[2]");
    public static By ITEMS=By.xpath("//div[@aria-label='1 פריטים בסל. לחץ לפירוט']");
    public static By REMOVEBUTTONCART = By.id("remove-cart");
    public static By CONFIRMATION = By.id("delete-cart-btn");
    public static By CATAGORY = By.xpath("//div[1]/div[2][@role='list']");
    public static By PRODUCTS =By.xpath("//div[starts-with(@id, 'min-height-product-')]");
    public static By ADDBUTTON=  By.xpath("//button[@class='focus-item btn-acc plus no-select']");
    public static By DELEVIRYMODELE =By.id("delivery-modal");
    public static By CLOSEMODELE = By.id("close-popup");
    public static By CLOSEPOPUP = By.id("close-popup");
    public static By CARTPRODUCT = By.xpath("//div[@aria-label='סל קניות']");
    public static By LISTPRODUCTS = By.xpath("//div[@aria-label='רשימת מוצרים בעגלת קניות']");
    public static By PRODUCTONTHELIST = By.cssSelector("#market > ul");
    public static By CARTELEMENT = By.xpath("//div[@class='z-index-9 position-fixed bottom-5 w-95']");





}
