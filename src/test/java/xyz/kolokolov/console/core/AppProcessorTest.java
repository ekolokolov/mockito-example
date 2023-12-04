package xyz.kolokolov.console.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import xyz.kolokolov.console.model.Command;
import xyz.kolokolov.console.model.Request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class AppProcessorTest {

    private AppProcessor sut;
    private RequestParser parser;
    private CommandDispatcher dispatcher;

    @BeforeEach
    void setUp() {
        this.parser = Mockito.mock(RequestParser.class);
        this.dispatcher = Mockito.mock(CommandDispatcher.class);
        this.sut = new AppProcessor(parser, dispatcher);
    }

    @Test
    void processTest() {
        // Given
        String input = "create hello";
        Request request = new Request(Command.UNKNOWN, "value message");

        Mockito.when(parser.processLine(input)).thenReturn(request);
        Mockito.when(dispatcher.dispatch(request)).thenReturn("Message");

        // When
        String result = sut.process(input);

        // Then
        assertEquals("Message", result);
    }

}