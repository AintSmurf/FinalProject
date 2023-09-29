package frontend.steps;

import frontend.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;



public class QuikPurchesRemoveSteps {
    private TestContext textContext;

    public QuikPurchesRemoveSteps(TestContext textContext) {
        this.textContext = textContext;
    }
    @Given(" i'am on home page")
    public void i_am_on_the_homepage() {
        textContext.getHomePage();
    }


    @And(": i click on QuickBuy")
    public void iClickOnQuickBuy() {
        textContext.getHomePage().openFastPurches();

    }

    @When("I write the products:")
    public void iWriteTheProducts(List<String> productsToAdd) {
        textContext.getHomePage().writeList(productsToAdd);
    }

    @And("I start adding all of them to the cart")
    public void iStartAddingAllOfThemToTheCart() throws InterruptedException {
        textContext.getHomePage().Contunie(2);
        textContext.getHomePage().add(3,2);
    }

    @Then("I remove it")
    public void iRemoveIt() {
        textContext.getHomePage().backtoList();
        textContext.getHomePage().deletTheList();
        
    }

    @And("I have an empty list")
    public void iHaveAnEmptyList() {
        Assert.assertTrue(textContext.getHomePage().checkIfTheListEmpty());
    }
}
