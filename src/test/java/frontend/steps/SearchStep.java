package frontend.steps;

import frontend.context.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;



public class SearchStep {
    private TextContext textContext;
    private String Url;
    public SearchStep(TextContext textContext){
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
