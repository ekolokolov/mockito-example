package xyz.kolokolov.console.core;

import xyz.kolokolov.console.model.Request;

public class AppProcessor {

    private final RequestParser parser;
    private final CommandDispatcher dispatcher;

    public AppProcessor(RequestParser parser, CommandDispatcher dispatcher) {
        this.parser = parser;
        this.dispatcher = dispatcher;
    }

    public String process(String command){
        Request request = parser.processLine(command);
        return dispatcher.dispatch(request);
    }
}
