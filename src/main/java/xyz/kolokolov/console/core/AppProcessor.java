package xyz.kolokolov.console.core;

import xyz.kolokolov.console.model.Request;

public class AppProcessor {

    private final RequestParser parser = new RequestParser();
    private final CommandDispatcher dispatcher = new CommandDispatcher();

    public String process(String command){
        Request request = parser.processLine(command);
        return dispatcher.dispatch(request);
    }
}
