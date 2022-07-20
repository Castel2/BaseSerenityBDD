package org.automatizacion.prueba.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.automatizacion.prueba.models.Account;
import org.automatizacion.prueba.tasks.NavigateTo;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.automatizacion.prueba.utils.GeneralConstants.USER;

public class AddProductsStepDefinitions {

    @Managed
    private WebDriver driver;

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(USER);
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
    }

    @Given("^User logs in the whit credentials$")
    public void userLogsInTheWhitCredentials(List<Account> accountList) {
        System.out.println("ENTRO");
        OnStage.theActorInTheSpotlight().wasAbleTo(NavigateTo.site());
    }

    @When("^Select product from (.*)$")
    public void selectProductFrom(String arg1) {
    }

    @Then("^View the product in the shopping cart$")
    public void viewTheProductInTheShoppingCart() {
    }



}
