package frontend.steps;

import frontend.context.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddTheCheapest {
  private   TextContext textContext;

    public AddTheCheapest(TextContext textContext) {
        this.textContext = textContext;
    }
    @Given("I am logged inn")
    public void i_am_logged_inn() throws Exception {
        textContext.getHomePage();
        textContext.login("knawras17@gmail.com", "123nawras");
    }

    @When("i got to frozens sectionn")
    public void i_got_to_frozens_sectionn() {
        textContext.getFrozen().Navigate();
    }
    @And("i ckick on sort")
    public void i_ckick_on_sort() throws InterruptedException {
        textContext.getFrozen().sortFromCheapTo(3);

    }
    @And("add the first product to the cart")
    public void add_the_first_product_to_the_cart() throws InterruptedException {
        textContext.sorted().addTheCheapestItem();
        textContext.getFrozen().close();
    } //delete this

    @Then("i have the cheapest product in the cart")
    public void i_have_the_cheapest_product_in_the_cart() throws InterruptedException {
        textContext.sorted().opencart();
        String priceText = textContext.sorted().checkTheCart();

        Assert.assertEquals("4.70 ₪",priceText);



    }
}
