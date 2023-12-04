package xyz.kolokolov.console.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import xyz.kolokolov.console.controllers.MainController;
import xyz.kolokolov.console.model.Command;
import xyz.kolokolov.console.model.Request;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandDispatcherTest {

    private CommandDispatcher sut;
    private MainController mainController;

    @BeforeEach
    void setUp() {
        this.mainController = Mockito.mock(MainController.class);
        this.sut = new CommandDispatcher(mainController);
    }

    @Test
    void dispatchCreateTest() {
        // Given
        String value = "value";
        Request request = new Request(Command.CREATE, value);
        Mockito.when(mainController.crete(request.value())).thenReturn("response");

        // When
        String result = sut.dispatch(request);

        // Then
        assertEquals("response", result);
        Mockito.verify(mainController, Mockito.times(0)).delete(value);
        Mockito.verify(mainController, Mockito.times(0)).list(value);
    }

    @Test
    void dispatchListTest() {
        // Given
        String value = "value";
        Request request = new Request(Command.LIST, value);
        Mockito.when(mainController.list(request.value())).thenReturn("response");

        // When
        String result = sut.dispatch(request);

        // Then
        assertEquals("response", result);
        Mockito.verify(mainController, Mockito.times(0)).crete(value);
        Mockito.verify(mainController, Mockito.times(0)).delete(value);
    }

    @Test
    void dispatchDeleteTest() {
        // Given
        String value = "value";
        Request request = new Request(Command.DELETE, value);
        Mockito.when(mainController.delete(request.value())).thenReturn("response");

        // When
        String result = sut.dispatch(request);

        // Then
        assertEquals("response", result);
        Mockito.verify(mainController, Mockito.times(0)).crete(value);
        Mockito.verify(mainController, Mockito.times(0)).list(value);
    }

    @Test
    void dispatchUnknownTest() {
        // Given
        String value = "value";
        Request request = new Request(Command.UNKNOWN, value);

        // When
        String result = sut.dispatch(request);

        // Then
        assertEquals(value, result);
        Mockito.verifyNoInteractions(mainController);
    }
}