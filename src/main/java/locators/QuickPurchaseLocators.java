package locators;

import org.openqa.selenium.By;

public class QuickPurchaseLocators {
    public static By CREATE_LIST = By.id("quick-buy-btn");

    public static By PRODUCT_LIST= By.id("list-product");
    public static By CONTUNIE = By.xpath("//div[@aria-label='המשך']");

    public static By NEXT = By.xpath("//div[@aria-label='הבא']");
    public static By CANCLE = By.xpath("//div[@aria-label='ביטול']");
    public static By DELET_LIST = By.xpath("//button[@aria-label='מחק רשימה']");

    public static By CONFIRM_DELETE = By.xpath("//*[@id=\"rating___BV_modal_body_\"]/div/div/div[2]/div[2]");
    public static By CANCLE_DELETE = By.xpath("//div[@aria-label='לא']");
    public static By POPUP_DELETE= By.xpath("//*[@id=\"rating___BV_modal_body_\"]/div/div");
    public static By RESULTS =By.xpath("//div[@class='d-flex flex-wrap justify-content-between p-1']");
    public static By FIRST = By.xpath("//button[@aria-label id='product-7290004131074']");
    public static By NEXT1 = By.xpath("//*[@id=\"__BVID__414___BV_modal_body_\"]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div[1]");
    public static By FINISHED = By.xpath("//div[@aria-label='סיימתי, בלחיצה על כפתור זה המוצרים יתווספו לסל']");
    public static By GO_TO_LIST= By.xpath("//div[@aria-label='לחץ למעבר להתחלה לצפייה ברשימה שכתבת']");
    public static By LIST_AFTER_REMOVE = By.id("list-product");
    public static By MODELE =  By.id("delivery-modal");
    public static By CLOSEPOP= By.id("close-popup");
    public static By RESULT_PRODUCTS = By.xpath("//div[@class='product-gallery-wrap flex-row-50 big-plus-minus item-card position-relative is-buy-list']");
}
