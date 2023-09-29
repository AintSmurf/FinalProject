package frontend.steps;

import frontend.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QuickPurchesToEnd {
    private TestContext textContext;

    public QuickPurchesToEnd(TestContext textContext) {
        this.textContext = textContext;
    }

    @Given("I am on homepage")
    public void iAmOnHomepage() {
        textContext.getHomePage();
        
    }

    @And("I click on QuickBuy")
    public void iClickOnQuickBuy() {
        textContext.getHomePage().openFastPurches();
        
    }

    @When("I start add these products:")
    public void iStartAddTheseProducts(List<String> ProductsToAdd) {
        textContext.getHomePage().writeList(ProductsToAdd);
    }

    @And("I start adding all of the products to the cart")
    public void iStartAddingAllOfTheProductsToTheCart() throws InterruptedException {
        textContext.getHomePage().Contunie(2);
        textContext.getHomePage().add(3,1);
    }
    @And("click on finished")
    public void clickOnFinished() {
        textContext.getHomePage().finishTheList();

    }
    @Then("I have the products in the cart")
    public void iHaveTheProductsInTheCart() {
        List<String> expectedOutput = new ArrayList<>(Arrays.asList(
                "שוקו יטבתה 1 ליטר",
                "בונבוניירת פררו רושה 200 גרם",
                "במבה חטיף בוטנים אסם 10*25 גרם",
                "מחיר משלוח"
        ));
        List<String> actuallOutput = textContext.getHomePage().verifyProductInTheCart();
        Assert.assertEquals(expectedOutput,actuallOutput);


    }
}
