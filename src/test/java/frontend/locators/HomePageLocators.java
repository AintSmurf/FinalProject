package frontend.locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static By LOGINUSER = By.id("login-user");
    public static By SEARCH = By.id("destination");
    public static By cart = By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[1]/span/svg");
    public static By FILTER= By.xpath("//*[@id=\"search\"]/div/div/div[1]/div/div[1]/div/div[1]/div[3]");
    public static By MAIN_PAGE = By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[1]/div[3]/div[2]/div/div[1]");
    public static By SALES = By.id("sale");
    public static By HISTORY = By.id("history");
    public static By FRUITS = By.xpath("//*[@id=\"main-menu-0\"]");
    public static By DAIRY = By.xpath("//*[@id=\"main-menu-1\"]");
    public static By MEATS = By.xpath("//*[@id=\"main-menu-2\"]");
    public static By ORGANIC = By.xpath("//*[@id=\"main-menu-3\"]");
    public static By FROZENS = By.xpath("//*[@id=\"main-menu-4\"]");
    public static By BAKING = By.xpath("//*[@id=\"main-menu-5\"]");
    public static By GRAINS = By.xpath("//*[@id=\"main-menu-6\"]");
    public static By CANDIES = By.xpath("//*[@id=\"main-menu-7\"]");
    public static By DRINKS = By.xpath("//*[@id=\"main-menu-8\"]");
    public static By DISPOSABLE  = By.xpath("//*[@id=\"main-menu-9\"]");
    public static By HOUSEKEEPING = By.xpath("//*[@id=\"main-menu-10\"]");
    public static By BABIES = By.xpath("//*[@id=\"main-menu-11\"]");
    public static By PASTRIES = By.xpath("//*[@id=\"main-menu-12\"]");

    public static By SORTING = By.xpath("//div[@aria-label='סינון']");

    public static By TO_PAY = By.xpath("//div[contains(@class, 'focus-item') and contains(@class, 'd-flex-') and contains(@class, 'white-text') and contains(@class, 'w-100') and contains(@class, 'px-3-') and contains(@class, 'pl-md-5')]");

    public static By LOGIN = By.id("login-user");
    public static By USERINPUT = By.id("email");
    public static By PASSWORD = By.id("password");
    public static By LOGINButton = By.xpath("//button[@aria-label='כניסה']");






}
