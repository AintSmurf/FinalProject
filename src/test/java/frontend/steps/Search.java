package frontend.steps;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


public class Search {
    private TestContext textContext;
    private String Keyword;
    private HomePage homePage;
    public Search(TestContext textContext){
        this.textContext=textContext;
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
      homePage = textContext.get("homepage");
    }
    @When("I search for {string}")
    public void i_search(String keyword) {
        homePage.searchStuff(keyword);

    }
    @Then("I verify the keyword {string}")
    public void iVerifyTheKeyword(String result) {
        assertTrue(homePage.getSearchKeyword().equals(result));

    }


}
