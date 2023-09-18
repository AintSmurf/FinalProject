package frontend;

import frontend.pages.HomePage;
import frontend.pages.MyLisPage;
import frontend.pages.frozensPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/knawr/IdeaProjects/FinalProject/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        MyLisPage homePage=new MyLisPage(driver);
        frozensPage fro = new frozensPage(driver);
        fro.additem();
        fro.goToVhrckOut();
        fro.verfyCart();
//      homePage.openList();
//      String[] mylist = {"חלב","לחם","בשר"};
//       homePage.writeList(mylist);
//       homePage.Contunie(5);
//       homePage.add(3,1);
//       homePage.finishTheList();

//
//
//       HomePage page=new HomePage(driver);
//       page.sortFromCheapTo();
        // page.goToPay();
//        page.searchstuff("מים");
//        page.returnToMain();
      //  page.sortFromCheapTo();

    }
}
