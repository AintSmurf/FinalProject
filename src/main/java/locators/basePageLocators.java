package locators;

import org.openqa.selenium.By;

public class basePageLocators {
    public static By CART = By.xpath("//div[@class='z-index-9 position-fixed bottom-5 w-95']");
    public static By SORTICON = By.xpath("//div[@class='blue s-text mx-3 d-none d-lg-block']");
    public static By SORTOPTIONS =By.xpath("//button[@aria-label='אפשרויות מיון וסינון, מיין לפי רלוונטיות']");
    public static By SORTBYCHEAPEST = By.xpath("//li[@class='sort-list-item gray-hover border-radius-10 py-2 m-1']");
    public static By AFTERSORTLIST = By.xpath("//div[1]/div[2][@role='list']");
    public static By CHEAPESTITEMONTHELIST = By.xpath("//div[starts-with(@id, 'min-height-product-')]");
    public static By ADDBUTTON = By.xpath("//button[@class='focus-item btn-acc plus no-select']");
    public static By ELEMNTTOCHECKTHEEMPTY= By.id("full-quick");
    public static By SCROLL = By.id("scroll-cart");
}
