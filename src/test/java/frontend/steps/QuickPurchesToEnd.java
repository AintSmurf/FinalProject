package frontend.steps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class QuickPurchesToEnd {
    private TestContext textContext;
    private HomePage homePage;

    public QuickPurchesToEnd(TestContext textContext) {
        this.textContext = textContext;
    }

    @Given("I am on homepage")
    public void iAmOnHomepage() {
        homePage = textContext.get("homepage");
        
    }

    @And("I click on QuickBuy")
    public void iClickOnQuickBuy() {
        homePage.openFastPurchase();
        
    }

    @When("I start add these products:")
    public void iStartAddTheseProducts(List<String> ProductsToAdd) {
        homePage.writeList(ProductsToAdd);
    }

    @And("I start adding all of the products to the cart")
    public void iStartAddingAllOfTheProductsToTheCart() throws InterruptedException {
        homePage.Continue(2);
        homePage.add(3,1);
    }
    @And("click on finished")
    public void clickOnFinished() {
        homePage.finishTheList();

    }

    @Then("I have the products in the cart:")
    public void iHaveTheProductsInTheCart(List<String> Products) {
        homePage.removeCart();
        String temp = homePage.checkTheCart();
        assertEquals(Products.size(),buildString(temp).size());
    }

    private static List<String> buildString(String text) {
        String[] lines = text.split("\n");

        List<String> resultList = new ArrayList<>();

        for (String line : lines) {
            if (line.contains("גרם") || line.contains("ליטר")) {
                resultList.add(line);
            }
        }
        return resultList;
    }

}
