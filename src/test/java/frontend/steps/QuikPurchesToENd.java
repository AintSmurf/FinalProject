package frontend.steps;

import frontend.context.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;

import java.util.List;

public class QuikPurchesToENd {
    private TextContext textContext;
    public QuikPurchesToENd(TextContext textContext) {
        this.textContext = textContext;
    }

    @Given("I am on the home pag")
    public void i_am_on_the_home_pagee() {
        textContext.getHomePage();
    }
    @Given("I open myList tapp")
    public void i_open_my_list_tapp()  {
        textContext.getHomePage().openFastPurches();
    }

    @When("adding these proucts:")
    public void i_add_the_these_products_to_the_list(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<String> productsToAdd = dataTable.asList(String.class);
        textContext.myList().writeList(productsToAdd);
        textContext.myList().Contunie(2);
        textContext.myList().add(3, 2);
    }
    @And("click on finished")
    public void click_on_finished(){
        textContext.myList().finishTheList();
    }

    @Then("I have milk and meat and icecream on my cart")
    public void i_have_milk_and_meat_and_icecream_on_my_cart() {

    }
}
