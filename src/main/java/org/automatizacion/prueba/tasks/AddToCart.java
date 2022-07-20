package org.automatizacion.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static org.automatizacion.prueba.userinterfaces.ProductsPage.BUTTON_ADD_CART;
import static org.automatizacion.prueba.userinterfaces.ProductsPage.BUTTON_CART;
import static org.automatizacion.prueba.utils.GeneralConstants.PRICE;

public class AddToCart implements Task {

    private String price;

    public AddToCart(String price) {
        this.price = price;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BUTTON_ADD_CART.of(price)),
                Click.on(BUTTON_CART));
        actor.remember(PRICE,price);
    }

    public static AddToCart with(String price){
        return Tasks.instrumented(AddToCart.class, price);
    }
}
