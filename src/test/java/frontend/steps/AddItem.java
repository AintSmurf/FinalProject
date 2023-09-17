package frontend.steps;

import frontend.context.TextContext;
import io.cucumber.java.en.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class AddItem {
    public TextContext textContext;

    public AddItem(TextContext textContext){
        this.textContext = textContext;
    }
    @Given("I am logged in")
    public void i_am_logged_in()  throws URISyntaxException, IOException, InterruptedException {
        textContext.getHomePage();
        textContext.login("knawras17@gmail.com","123nawras");
        textContext.getHomePage().refresh();
    }
    @When("I add an item")
    public void i_add_an_item() {
        System.out.println("dsadsad");
    }
    @Then("the cart has a single item in it")
    public void the_cart_has_a_single_item_in_it() {
        System.out.println("hello");
    }


}
