package frontend.steps;

import frontend.context.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;

public class RemoveTheCart {
    public TextContext textContext;

    public RemoveTheCart(TextContext textContext){

        this.textContext = textContext;
    }


    @Given("iam in the frozen page")
    public void iam_in_the_frozen_page() {
        textContext.getFrozen().Navigate();
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
       Thread.sleep(10000);
        String valueCart = textContext.getFrozen().EmptyCart();
        Assert.assertTrue( valueCart.matches("לתשלום\\s*0.00 ₪"));
    }


}
