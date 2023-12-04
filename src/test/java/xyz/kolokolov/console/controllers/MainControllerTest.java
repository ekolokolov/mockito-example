package xyz.kolokolov.console.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.kolokolov.console.core.PeopleRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    private MainController sut;

    @Mock
    private PeopleRepository peopleRepository;

    @BeforeEach
    void setUp() {
        this.sut = new MainController(peopleRepository);
    }

    @Test
    void crete() {
        // Given
        String request = "request";
        when(peopleRepository.create(request)).thenReturn(1);

        // When
        String name = sut.crete(request);

        // Then
        assertEquals("Person request - 1's was created.", name);
    }

    @Test
    void deleteCountTest() {
        // Given
        String request = "request";
        when(peopleRepository.delete(request)).thenReturn(78);

        // When
        String name = sut.delete(request);

        // Then
        assertEquals("78 persons with name \"request\" was deleted.", name);
    }


    @Test
    void listCountTest() {
        // Given
        String request = "request";
        when(peopleRepository.find(request)).thenReturn(33);

        // When
        String name = sut.list(request);

        // Then
        assertEquals("33 persons with name \"request\" was found.", name);
    }

}