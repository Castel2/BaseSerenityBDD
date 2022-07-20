package org.automatizacion.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.automatizacion.prueba.models.Account;

import static org.automatizacion.prueba.userinterfaces.LoginPage.*;

public class LogIn implements Task {

    private Account account;

    public LogIn(Account account) {
        this.account = account;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(account.getUsername()).into(INPUT_USERNAME),
                Enter.theValue(account.getPassword()).into(INPUT_PASSWORD),
                Click.on(BUTTON_LOGIN));
    }

    public static LogIn whit(Account account){
        return Tasks.instrumented(LogIn.class, account);
    }
}
