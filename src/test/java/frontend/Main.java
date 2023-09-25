package frontend;

import backend.HttpHelper;
import frontend.pages.FrozensPage;
import frontend.pages.QuiekPurchesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException, URISyntaxException, IOException {
        System.setProperty("webdriver.chrome.driver","C:/Users/knawr/IdeaProjects/FinalProject/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.rami-levy.co.il/he");
//        HttpHelper.login(driver,"knawras17@gmail.com","123nawras");
         QuiekPurchesPage lisPage=new QuiekPurchesPage(driver);

      //  HomePage page=new HomePage(driver);
//   FrozensPage fro = new FrozensPage(driver);
//        // page.searchStuff("גלידה");
//     //   fro.sortFromCheapTo(3);
//
//      // page.refresh();
//     fro.addItemsToCart();
//     fro.close();
//    fro.removeCart();
//
//    fro.EmptyCart();


   //  fro.goToVhrckOut();
     //fro.verfyCart();
      // lisPage.openFastPurches();
        List<String> productsToAdd = Arrays.asList("בשר", "מים", "גלידה");

      lisPage.writeList(productsToAdd);
       lisPage.Contunie(2);
        lisPage.add(3, 2);
        lisPage.backtoList();
         lisPage.deletTheList();
         lisPage.checkIfTheListEmpty();

        // lisPage.add(3,1);

//      lisPage.finishTheList();
//        HomePage page=new HomePage(driver);
//        page.gotoCheckOut();

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
