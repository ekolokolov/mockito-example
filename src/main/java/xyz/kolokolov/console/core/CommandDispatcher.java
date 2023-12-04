package xyz.kolokolov.console.core;

import xyz.kolokolov.console.controllers.MainController;
import xyz.kolokolov.console.model.Request;

public class CommandDispatcher {

    private final MainController mainController;

    public CommandDispatcher(MainController mainController) {
        this.mainController = mainController;
    }

    public String dispatch(Request command) {
        return switch (command.command()) {
            case CREATE -> mainController.crete(command.value());
            case DELETE -> mainController.delete(command.value());
            case LIST -> mainController.list(command.value());
            case UNKNOWN -> command.value();
        };

    }
}
