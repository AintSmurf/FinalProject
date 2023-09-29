package frontend.steps;

import frontend.context.TestContext;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.io.IOException;
import java.net.URISyntaxException;

public class AddItem {
    public TestContext textContext;

    public AddItem(TestContext textContext){

        this.textContext = textContext;
    }
    @Given("I'am on homepage")
    public void iAmOnHomepage() throws URISyntaxException, IOException, InterruptedException {
        textContext.getHomePage();

    }

    @When("i got to frozens section")
    public void i_got_to_frozens_section() {
        textContext.getFrozen().Navigate();
    }
    @And("i add a random item")
    public void i_add_a_random_item() throws InterruptedException{
         textContext.getFrozen().addItemsToCart();
        Thread.sleep(5000);
        textContext.getFrozen().close();

    }
    @Then("the cart has a single item in it")
    public void the_cart_has_a_single_item_in_it() throws InterruptedException {
       int productsNum= textContext.getFrozen().verfyCart();
        Assert.assertEquals(2,productsNum);


    }



}

