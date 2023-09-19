package frontend;

import backend.HttpHelper;
import frontend.pages.HomePage;
import frontend.pages.MyLisPage;
import frontend.pages.frozensPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws InterruptedException, URISyntaxException, IOException {
        System.setProperty("webdriver.chrome.driver","C:/Users/knawr/IdeaProjects/FinalProject/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rami-levy.co.il/he");
        HttpHelper.login(driver,"knawras17@gmail.com","123nawras");
      //  MyLisPage homePage=new MyLisPage(driver);

        HomePage page=new HomePage(driver);
        frozensPage fro = new frozensPage(driver);
     //   fro.sortFromCheapTo(3);

//       page.refresh();
       fro.additem();
     // fro.goToVhrckOut();
     //   fro.verfyCart();
//      homePage.openList();
//      String[] mylist = {"חלב","לחם","בשר"};
//       homePage.writeList(mylist);
//       homePage.Contunie(5);
//       homePage.add(3,1);
//       homePage.finishTheList();

//
//
//      HomePage page=new HomePage(driver);
////      page.refresh();
////      page.sortFromCheapTo(3);
//       page.sortFromCheapTo();
        // page.goToPay();
//        page.searchstuff("מים");
//        page.returnToMain();
      //  page.sortFromCheapTo();

    }
}
