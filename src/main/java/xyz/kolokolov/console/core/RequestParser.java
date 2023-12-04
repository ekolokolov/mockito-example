package xyz.kolokolov.console.core;

import xyz.kolokolov.console.model.Command;
import xyz.kolokolov.console.model.Request;
import xyz.kolokolov.console.valudation.InputValidator;

public class RequestParser {

    private static final String ERROR_MESSAGE = "Unknown command.";
    private static final String SPACE = " ";
    private static final int COMMAND_INDEX = 0;
    private static final int VALUE_INDEX = 1;

    private final InputValidator validator;

    public RequestParser(InputValidator validator) {
        this.validator = validator;
    }

    public Request processLine(String string){
        if (!validator.validate(string)) {
            return new Request(Command.UNKNOWN, ERROR_MESSAGE);
        }

        String[] chunks = string.split(SPACE);
        String command = chunks[COMMAND_INDEX];
        String value = chunks[VALUE_INDEX];
        return new Request(Command.valueOf(command.toUpperCase()), value);
    }
}
