package frontend.locators;

import org.openqa.selenium.By;

public class QuieckPurchesLocators {
    public static By createList = By.cssSelector("#quick-buy-btn");
    public static By productsList= By.id("list-product");
    public static By contunie = By.xpath("//div[@aria-label='המשך']");

    public static By addItemAterSearch =By.id("Capa_1");
    public static By cancle = By.xpath("//div[@aria-label='ביטול']");
    public static By deleteList = By.xpath("//button[@aria-label='מחק רשימה']");

    public static By confirmationdelete = By.xpath("//*[@id=\"rating___BV_modal_body_\"]/div/div/div[2]/div[2]");
    public static By cancleDelete = By.xpath("//div[@aria-label='לא']");
    public static By popupDelet= By.xpath("//*[@id=\"rating___BV_modal_body_\"]/div/div");
    public static By results =By.xpath("//div[@class='d-flex flex-wrap justify-content-between p-1']");
    public static By first = By.xpath("//button[@aria-label id='product-7290004131074']");
    public static By next = By.xpath("//*[@id=\"__BVID__414___BV_modal_body_\"]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div[1]");
    public static By finished = By.xpath("//div[@aria-label='סיימתי, בלחיצה על כפתור זה המוצרים יתווספו לסל']");
    public static By goTolist= By.xpath("//div[@aria-label='לחץ למעבר להתחלה לצפייה ברשימה שכתבת']");
}
