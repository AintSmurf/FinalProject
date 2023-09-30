package frontend.steps;

import context.TestContext;
import pages.FrozensPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.HomePage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AddItem {
    private TestContext testContext;
    private FrozensPage frozenPage;
    private HomePage homePage;

    public AddItem(TestContext testContext){
        this.testContext = testContext;
    }
    @Given("I'am on homepage")
    public void iAmOnHomepage(){
        homePage = testContext.get("homepage");

    }
    @When("i am navigating to frozen page")
    public void i_am_navigating_to_frozen_page() {
        testContext.put("FrozenPage",homePage.NavigateToFrozen());
    }

    @And("i add a random item")
    public void i_add_a_random_item(){
        frozenPage=testContext.get("FrozenPage");
        frozenPage.addItemsToCart();
    }
    @Then("the cart has a single item in it")
    public void the_cart_has_a_single_item_in_it(){
        int productsNum= frozenPage.verifyCart();
        Assert.assertEquals(2,productsNum);
    }

    @And("i click on sort")
    public void i_click_on_sort(){
        frozenPage=testContext.get("FrozenPage");
        frozenPage.sortByCheapest(3);

    }
    @And("add the first product to the cart")
    public void add_the_first_product_to_the_cart(){
        frozenPage.addTheCheapestItem();
    }

    @Then("i have the cheapest product in the cart")
    public void i_have_the_cheapest_product_in_the_cart(){
        frozenPage.opencart();
        assertTrue(frozenPage.checkTheCart().contains("6.20 ₪"));
    }

    @And(": i click on QuickBuy")
    public void iClickOnQuickBuy() {
        homePage.openFastPurchase();

    }

    @And("I write the products:")
    public void iWriteTheProducts(List<String> productsToAdd) {
        homePage.writeList(productsToAdd);
    }

    @And("I start adding all of them to the cart")
    public void iStartAddingAllOfThemToTheCart() throws InterruptedException {
        homePage.Continue(2);
        homePage.add(3,2);
    }

    @Then("I remove it")
    public void iRemoveIt() {
        homePage.backtoList();
        homePage.deleteTheList();

    }

    @And("I have an empty list")
    public void iHaveAnEmptyList() {
        Assert.assertTrue(homePage.checkIfTheListEmpty());
    }




}

