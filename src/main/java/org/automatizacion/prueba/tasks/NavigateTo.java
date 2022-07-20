package org.automatizacion.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

import static org.automatizacion.prueba.utils.GeneralConstants.URL;

public class NavigateTo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(URL));
    }

    public static NavigateTo site(){
        return Tasks.instrumented(NavigateTo.class);
    }

}
