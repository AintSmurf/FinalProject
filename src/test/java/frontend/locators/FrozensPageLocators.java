package frontend.locators;

import org.openqa.selenium.By;

public class FrozensPageLocators {
    public static By TO_PAY =By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div[2]");

    public static By LISTFROZENS= By.xpath("//div[1]/div[2][@role='list']");
    public static By ADD_ITEM =  By.id("Capa_1");
    public static By CLOSE_AD=By.id("close-popup");
    public static By CLICKONCART=By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div[2]");
    public static By ITEMS=By.xpath("//div[@aria-label='1 פריטים בסל. לחץ לפירוט']");

}
