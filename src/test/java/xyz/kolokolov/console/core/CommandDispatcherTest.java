package xyz.kolokolov.console.core;

import org.junit.jupiter.api.Test;
import xyz.kolokolov.console.model.Command;
import xyz.kolokolov.console.model.Request;

import static org.junit.jupiter.api.Assertions.*;

class CommandDispatcherTest {

    @Test
    void dispatchCreateTest() {
        CommandDispatcher commandDispatcher = new CommandDispatcher();
        String result = commandDispatcher.dispatch(new Request(Command.CREATE, "value"));
        assertEquals("Person value - 1's was created.", result);
    }

    @Test
    void dispatchListTest() {
        CommandDispatcher commandDispatcher = new CommandDispatcher();
        String result = commandDispatcher.dispatch(new Request(Command.LIST, "value"));
        assertEquals("0 persons with name \"value\" was found.", result);
    }

    @Test
    void dispatchDeleteTest() {
        CommandDispatcher commandDispatcher = new CommandDispatcher();
        String result = commandDispatcher.dispatch(new Request(Command.DELETE, "value"));
        assertEquals("0 persons with name \"value\" was deleted.", result);
    }
    @Test
    void dispatchUnknownTest() {
        CommandDispatcher commandDispatcher = new CommandDispatcher();
        String result = commandDispatcher.dispatch(new Request(Command.UNKNOWN, "value"));
        assertEquals("value", result);
    }
}