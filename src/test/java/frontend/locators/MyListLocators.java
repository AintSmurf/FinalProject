package frontend.locators;

import org.openqa.selenium.By;

public class MyListLocators {
    public static By createList = By.cssSelector("#quick-buy-btn");
    public static By productsList= By.id("list-product");
    public static By contunie = By.xpath("//div[@aria-label='המשך']");

    public static By cancle = By.xpath("//div[@aria-label='ביטול']");
    public static By deleteList = By.xpath("//button[@aria-label='מחק רשימה']");
    public static  By listItems = By.xpath("//div[@class='d-flex flex-wrap justify-content-between p-1']");
    public static By addItemAterSearch = By.xpath("//div[@aria-label='הוסף 1 יחידות לחלב תנובה טרי1ל קרטון 3% מהדרין לסל הקניות']");
    public static By deleteCart = By.xpath("//*[@id=\"remove-cart\"]/svg");
    public static By confirmation = By.xpath("//*[@id=\"delete-cart-btn\"]");
    public static By cancleDelete = By.id("noEmptyCart");
}
