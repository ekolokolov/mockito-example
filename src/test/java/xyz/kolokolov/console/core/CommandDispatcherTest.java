package xyz.kolokolov.console.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.kolokolov.console.controllers.MainController;
import xyz.kolokolov.console.model.Command;
import xyz.kolokolov.console.model.Request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommandDispatcherTest {

    private CommandDispatcher sut;
    @Mock
    private MainController mainController;

    @BeforeEach
    void setUp() {
        this.sut = new CommandDispatcher(mainController);
    }

    @Test
    void dispatchCreateTest() {
        // Given
        String value = "value";
        Request request = new Request(Command.CREATE, value);
        when(mainController.crete(request.value())).thenReturn("response");

        // When
        String result = sut.dispatch(request);

        // Then
        assertEquals("response", result);
        verify(mainController, times(0)).delete(value);
        verify(mainController, times(0)).list(value);
    }

    @Test
    void dispatchListTest() {
        // Given
        String value = "value";
        Request request = new Request(Command.LIST, value);
        when(mainController.list(request.value())).thenReturn("response");

        // When
        String result = sut.dispatch(request);

        // Then
        assertEquals("response", result);
        verify(mainController, times(0)).crete(value);
        verify(mainController, times(0)).delete(value);
    }

    @Test
    void dispatchDeleteTest() {
        // Given
        String value = "value";
        Request request = new Request(Command.DELETE, value);
        when(mainController.delete(request.value())).thenReturn("response");

        // When
        String result = sut.dispatch(request);

        // Then
        assertEquals("response", result);
        verify(mainController, times(0)).crete(value);
        verify(mainController, times(0)).list(value);
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