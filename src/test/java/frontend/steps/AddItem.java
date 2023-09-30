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
    public void iAmOnHomepage(){
        textContext.getHomePage();

    }
    @When("i am navigating to frozen page")
    public void i_am_navigating_to_frozen_page() {
        textContext.getHomePage().NavigateToFrozen();
    }

    @And("i add a random item")
    public void i_add_a_random_item() throws InterruptedException{
         textContext.getFrozen().addItemsToCart();
        Thread.sleep(5000);
        textContext.getFrozen().close();

    }
    @Then("the cart has a single item in it")
    public void the_cart_has_a_single_item_in_it(){
       int productsNum= textContext.getFrozen().verifyCart();
        Assert.assertEquals(2,productsNum);
    }

    @And("i click on sort")
    public void i_click_on_sort(){
        textContext.sorted().sortFromCheapTo(3);

    }
    @And("add the first product to the cart")
    public void add_the_first_product_to_the_cart() throws InterruptedException {
        textContext.sorted().addTheCheapestItem();
        textContext.getFrozen().close();
    }

    @Then("i have the cheapest product in the cart")
    public void i_have_the_cheapest_product_in_the_cart(){
        textContext.sorted().opencart();
        String priceText = textContext.sorted().checkTheCart();
        Assert.assertEquals("4.70 ₪",priceText);
    }



}

