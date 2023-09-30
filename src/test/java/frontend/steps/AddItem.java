package frontend.steps;

import frontend.context.TextContext;
import io.cucumber.java.en.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class AddItem {
    private TextContext textContext;

    public AddItem(TextContext textContext){
        this.textContext = textContext;
    }
    @Given("I am logged in")
    public void i_am_logged_in() throws Exception {
        textContext.getHomePage();
        textContext.login(textContext.getEmail(), textContext.getPassword());
    }
    @When("navigate to frozenpage.")
    public void navigateToFrozenpage() throws URISyntaxException, IOException, InterruptedException {
    }
    @And("i add an item.")
    public void iAddAnItem() {
    }
    @Then("the cart has a single item in it")
    public void the_cart_has_a_single_item_in_it() {
        System.out.println("hello");
    }



}
