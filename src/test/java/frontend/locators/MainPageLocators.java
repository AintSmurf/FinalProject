package frontend.locators;

import org.openqa.selenium.By;

public class MainPageLocators {
    public static By LOGINUSER = By.id("login-user");
    public static By search = By.id("destination");
    public static By cart = By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[1]/span/svg");
    public static By filter= By.xpath("//*[@id=\"search\"]/div/div/div[1]/div/div[1]/div/div[1]/div[3]");
    public static By mainPage = By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[1]/div[3]/div[2]/div/div[1]");
    public static By sales = By.id("sale");
    public static By history = By.id("history");
    public static By fruits = By.xpath("//*[@id=\"main-menu-0\"]");
    public static By dairy = By.xpath("//*[@id=\"main-menu-1\"]");
    public static By meats = By.xpath("//*[@id=\"main-menu-2\"]");
    public static By organic = By.xpath("//*[@id=\"main-menu-3\"]");
    public static By frozens = By.xpath("//*[@id=\"main-menu-4\"]");
    public static By baking = By.xpath("//*[@id=\"main-menu-5\"]");
    public static By grains = By.xpath("//*[@id=\"main-menu-6\"]");
    public static By candies = By.xpath("//*[@id=\"main-menu-7\"]");
    public static By drinks = By.xpath("//*[@id=\"main-menu-8\"]");
    public static By Disposable  = By.xpath("//*[@id=\"main-menu-9\"]");
    public static By houseKeeping = By.xpath("//*[@id=\"main-menu-10\"]");
    public static By babies = By.xpath("//*[@id=\"main-menu-11\"]");
    public static By pastries = By.xpath("//*[@id=\"main-menu-12\"]");

    public static By sorting = By.xpath("//div[@aria-label='סינון']");

    public static By toPay = By.xpath("//div[contains(@class, 'focus-item') and contains(@class, 'd-flex-') and contains(@class, 'white-text') and contains(@class, 'w-100') and contains(@class, 'px-3-') and contains(@class, 'pl-md-5')]");








}
