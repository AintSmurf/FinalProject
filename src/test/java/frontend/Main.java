package frontend;

import frontend.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/knawr/IdeaProjects/FinalProject/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        HomePage homePage=new HomePage(driver);
        homePage.openList();
        String[] mylist = {"חלב","לחם","בשר"};
        homePage.writeList(mylist);
        homePage.Contunie(20);
        homePage.add();



    }
}
