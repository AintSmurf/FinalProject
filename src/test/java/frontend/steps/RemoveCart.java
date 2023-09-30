package frontend.steps;

import frontend.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RemoveCart {
    public TestContext textContext;

    public RemoveCart(TestContext textContext){

        this.textContext = textContext;
    }


    @Given("iam in the frozen page")
    public void iam_in_the_frozen_page() {
//        textContext.getFrozen().Navigate();
    }
    @When("i add a some item")
    public void i_add_a_some_item() throws InterruptedException {
        textContext.getFrozen().addItemsToCart();
    }
    @And("i remove all the cart")
    public void i_remove_all_the_cart() {
       textContext.getFrozen().removeCart();
    }
    @Then("i have an empty cart")
    public void i_have_an_empty_cart() throws InterruptedException {

        String valueCart = textContext.getFrozen().EmptyCart();
        Assert.assertTrue( valueCart.matches("לתשלום\\s*0.00 ₪"));
    }


}
