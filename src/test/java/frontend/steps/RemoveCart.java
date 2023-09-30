package frontend.steps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.FrozensPage;
import pages.HomePage;

public class RemoveCart {
    public TestContext textContext;
    private HomePage homePage;
    private FrozensPage frozensPage;

    public RemoveCart(TestContext textContext){

        this.textContext = textContext;
    }


    @Given("iam in the frozen page")
    public void iam_in_the_frozen_page() {
        homePage = textContext.get("homepage");
        frozensPage = homePage.NavigateToFrozen();
    }
    @When("i add a some item")
    public void i_add_a_some_item(){
        frozensPage.addItemsToCart();
    }
    @And("i remove all the cart")
    public void i_remove_all_the_cart() {
       frozensPage.removeCart();
    }
    @Then("i have an empty cart")
    public void i_have_an_empty_cart(){
        String valueCart = frozensPage.EmptyCart();
        Assert.assertTrue( valueCart.matches("לתשלום\\s*0.00 ₪"));
    }


}
