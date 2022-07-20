package org.automatizacion.prueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static org.automatizacion.prueba.userinterfaces.CartPage.TXT_PRICE;
import static org.automatizacion.prueba.utils.GeneralConstants.PRICE;

public class ValidateProductPrice implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Text.of(TXT_PRICE).viewedBy(actor).asString().contains(actor.recall(PRICE));
    }

    public static ValidateProductPrice iscorrect(){
        return new ValidateProductPrice();
    }
}
