package frontend.steps;

import frontend.context.TextContext;
import io.cucumber.java.en.*;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;

public class AddItem {
    public TextContext textContext;

    public AddItem(TextContext textContext){

        this.textContext = textContext;
    }
    @Given("I am logged in")
    public void i_am_logged_in() throws Exception {
        textContext.getHomePage();
        textContext.login("knawras17@gmail.com", "123nawras");
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

