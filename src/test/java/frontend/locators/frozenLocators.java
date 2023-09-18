package frontend.locators;

import org.openqa.selenium.By;

public class frozenLocators {
    public static By toPay =By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div[2]");

    public static By listFrozens= By.xpath("//div[1]/div[2][@role='list']");
    public static By addItem =  By.id("Capa_1");
    public static By closeAdd=By.id("close-popup");
    public static By clickOnCart=By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div[2]");
    public static By items=By.xpath("//div[@aria-label='1 פריטים בסל. לחץ לפירוט']");

}
