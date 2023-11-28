package xyz.kolokolov.console.core;

import org.junit.jupiter.api.Test;
import xyz.kolokolov.console.model.Command;
import xyz.kolokolov.console.model.Request;

import static org.junit.jupiter.api.Assertions.*;

class RequestParserTest {

    @Test
    void createLineTest() {
        RequestParser requestParser = new RequestParser();
        Request request = requestParser.processLine("create test");
        assertEquals(request.command(), Command.CREATE);
        assertEquals(request.value(), "test");
    }

    @Test
    void deleteLineTest() {
        RequestParser requestParser = new RequestParser();
        Request request = requestParser.processLine("delete test");
        assertEquals(request.command(), Command.DELETE);
        assertEquals(request.value(), "test");
    }

    @Test
    void updateLineTest() {
        RequestParser requestParser = new RequestParser();
        Request request = requestParser.processLine("list test");
        assertEquals(request.command(), Command.LIST);
        assertEquals(request.value(), "test");
    }

    @Test
    void unknownLineTest() {
        RequestParser requestParser = new RequestParser();
        Request request = requestParser.processLine("insert wrong");
        assertEquals(request.command(), Command.UNKNOWN);
        assertEquals(request.value(), "Unknown command.");
    }
}