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

    @Given(": i'am on home page")
    public void i_am_on_home_page() {
      homePage = textContext.get("homepage");
    }

    @When(": i search icecream")
    public void i_search() {
       homePage.searchStuff("גלידה");
    }


    @Then(": verify keyword {string}")
    public void verifyKeyword(String keyword) {
        assertTrue(homePage.getSearchKeyword().equals(keyword));
    }
}
