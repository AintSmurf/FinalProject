package frontend.steps;

import frontend.context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Search {
    private TestContext textContext;
    private String Url;
    public Search(TestContext textContext){
        this.textContext=textContext;
    }

    @Given(": i'am on home page")
    public void i_am_on_home_page() {
      textContext.getHomePage();
    }

    @When(": i search icecream")
    public void i_search() {
       textContext.getHomePage().searchStuff("גלידה");
       Url= textContext.getHomePage().getCurrentUrl();

    }

    @Then(": verfiy search works {string}")
    public void iam_on_ice_cream_result_page(String urlCucumber) {
        Assert.assertTrue(urlCucumber.equals(Url));
    }

}
