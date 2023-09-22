package frontend.steps;

import frontend.context.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class QuikPurchesRemoveSteps {
    private TextContext textContext;
    public QuikPurchesRemoveSteps(TextContext textContext) {
        this.textContext = textContext;
    }

    @Given("I am on the home pagee")
    public void i_am_on_the_home_pagee() {
        textContext.getHomePage();
    }
    @And("i open myList tap")
    public void i_open_myList_tap() throws InterruptedException {

        textContext.myList().openFastPurches();
    }

    @When("I add the these products to the list:")
    public void i_add_the_these_products_to_the_list(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<String> productsToAdd = dataTable.asList(String.class);
        textContext.myList().writeList(productsToAdd);
        textContext.myList().Contunie(2);
        textContext.myList().add(3, 2);
    }

    @And(": i go back to the List")
    public void i_go_back_to_the_list() {

        textContext.myList().backtoList();
       textContext.myList().deletTheList();
    }
    @And(": remove it")
    public void remove_it() throws InterruptedException {
        Thread.sleep(5000);
        textContext.myList().deletTheList();

    }
    @Then(": my list is empty")
    public void my_list_is_empty() {
        Assert.assertTrue(textContext.myList().checkIfTheListEmpty());
    }

}
