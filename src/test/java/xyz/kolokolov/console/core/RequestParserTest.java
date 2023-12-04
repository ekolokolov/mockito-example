package xyz.kolokolov.console.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.kolokolov.console.model.Command;
import xyz.kolokolov.console.model.Request;
import xyz.kolokolov.console.valudation.InputValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RequestParserTest {

    private RequestParser sut;
    @Mock
    private InputValidator validator;

    @BeforeEach
    void setUp() {
        this.sut = new RequestParser(validator);
    }

    @Test
    void createLineTest() {
        // Given
        String input = "create test";
        when(validator.validate(input)).thenReturn(true);

        // When
        Request request = sut.processLine(input);

        // Then
        assertEquals(request.command(), Command.CREATE);
        assertEquals(request.value(), "test");
    }

    @Test
    void deleteLineTest() {
        // Given
        String input = "delete test";
        when(validator.validate(input)).thenReturn(true);

        // When
        Request request = sut.processLine(input);

        // Then
        assertEquals(request.command(), Command.DELETE);
        assertEquals(request.value(), "test");
    }

    @Test
    void updateLineTest() {
        // Given
        String input = "list test";
        when(validator.validate(input)).thenReturn(true);

        // When
        Request request = sut.processLine(input);

        // Then
        assertEquals(request.command(), Command.LIST);
        assertEquals(request.value(), "test");
    }

    @Test
    void unknownLineTest() {
        // Given
        String input = "not_exits test";
        when(validator.validate(input)).thenReturn(false);

        // When
        Request request = sut.processLine(input);

        // Then
        assertEquals(request.command(), Command.UNKNOWN);
        assertEquals(request.value(), "Unknown command.");
    }
}