package xyz.kolokolov.console;

import xyz.kolokolov.console.controllers.MainController;
import xyz.kolokolov.console.core.*;
import xyz.kolokolov.console.valudation.InputValidator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppContext {

    public static Server createAppServer() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return new Server(bufferedReader, getApplication());
    }

    private static AppProcessor getApplication() {
        return new AppProcessor(getRequestParser(), getCommandDispatcher());
    }

    private static CommandDispatcher getCommandDispatcher() {
        return new CommandDispatcher(new MainController(new PeopleRepository()));
    }

    private static RequestParser getRequestParser() {
        return new RequestParser(getInputValidator());
    }

    private static InputValidator getInputValidator() {
        return new InputValidator();
    }
}
