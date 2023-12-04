package xyz.kolokolov.console.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.kolokolov.console.model.Command;
import xyz.kolokolov.console.model.Request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppProcessorTest {

    private AppProcessor sut;

    @Mock
    private RequestParser parser;
    @Mock
    private CommandDispatcher dispatcher;

    @BeforeEach
    void setUp() {
        this.sut = new AppProcessor(parser, dispatcher);
    }

    @Test
    void processTest() {
        // Given
        String input = "create hello";
        Request request = new Request(Command.UNKNOWN, "value message");

        when(parser.processLine(input)).thenReturn(request);
        when(dispatcher.dispatch(request)).thenReturn("Message");

        // When
        String result = sut.process(input);

        // Then
        assertEquals("Message", result);
    }

}