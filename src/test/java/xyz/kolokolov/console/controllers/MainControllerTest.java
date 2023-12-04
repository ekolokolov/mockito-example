package xyz.kolokolov.console.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import xyz.kolokolov.console.core.PeopleRepository;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    private MainController mainController;
    private PeopleRepository peopleRepository;

    @BeforeEach
    void setUp() {
        this.peopleRepository = Mockito.mock(PeopleRepository.class);
        this.mainController = new MainController(peopleRepository);
    }

    @Test
    void crete() {
        // Given
        String request = "request";
        Mockito.when(peopleRepository.create(request)).thenReturn(1);

        // When
        String name = mainController.crete(request);

        // Then
        assertEquals("Person request - 1's was created.", name);
    }

    @Test
    void deleteCountTest() {
        // Given
        String request = "request";
        Mockito.when(peopleRepository.delete(request)).thenReturn(78);

        // When
        String name = mainController.delete(request);

        // Then
        assertEquals("78 persons with name \"request\" was deleted.", name);
    }


    @Test
    void listCountTest() {
        // Given
        String request = "request";
        Mockito.when(peopleRepository.find(request)).thenReturn(33);

        // When
        String name = mainController.list(request);

        // Then
        assertEquals("33 persons with name \"request\" was found.", name);
    }

}