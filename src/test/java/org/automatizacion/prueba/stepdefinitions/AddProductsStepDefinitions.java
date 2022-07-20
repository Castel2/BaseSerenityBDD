package org.automatizacion.prueba.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.automatizacion.prueba.models.Account;
import org.automatizacion.prueba.interactions.OpenPage;
import org.automatizacion.prueba.questions.ValidateProductPrice;
import org.automatizacion.prueba.tasks.AddToCart;
import org.automatizacion.prueba.tasks.LogIn;
import org.automatizacion.prueba.utils.ExceptionsConstants;
import org.hamcrest.Matchers;
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
        OnStage.theActorInTheSpotlight().wasAbleTo(OpenPage.site(), LogIn.whit(accountList.get(0)));
    }

    @When("^Select product from (.*)$")
    public void selectProductFrom(String price) {
        OnStage.theActorInTheSpotlight().attemptsTo(AddToCart.with(price));
    }

    @Then("^View the product in the shopping cart$")
    public void viewTheProductInTheShoppingCart() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateProductPrice.iscorrect(),
                Matchers.equalTo(true)).orComplainWith(Error.class, ExceptionsConstants.CART_PRICE_ERROR));
    }



}
