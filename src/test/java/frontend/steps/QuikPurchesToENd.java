package frontend.steps;

import frontend.context.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;

import java.util.List;

public class QuikPurchesToENd {
    private TextContext textContext;
    public QuikPurchesToENd(TextContext textContext) {
        this.textContext = textContext;
    }

    @Given(": iam on homepage")
    public void iamOnHomepage() {
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
    @And("click on finished")
    public void click_on_finished(){
        textContext.getHomePage().finishTheList();
    }

    @Then("I have milk and meat and icecream on my cart")
    public void i_have_milk_and_meat_and_icecream_on_my_cart() {


    }


}
