package frontend;

import frontend.pages.HomePage;
import frontend.pages.MyLisPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/knawr/IdeaProjects/FinalProject/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        MyLisPage homePage=new MyLisPage(driver);
//        homePage.openList();
//      String[] mylist = {"חלב","לחם","בשר"};
//       homePage.writeList(mylist);
//       homePage.Contunie(5);
//       homePage.add();

       HomePage page=new HomePage(driver);
//        page.searchstuff("מים");
//        page.returnToMain();
        page.sortFromCheapTo();




    }
}
