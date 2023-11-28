package xyz.kolokolov.console.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    @Test
    void crete() {
        MainController mainController = new MainController();
        String name = mainController.crete("name");
        assertEquals("Person name - 1's was created.", name);
        name = mainController.crete("name");
        assertEquals("Person name - 2's was created.", name);
    }

    @Test
    void deleteCountTest() {
        MainController mainController = new MainController();
        mainController.crete("name");
        mainController.crete("name");
        String result = mainController.delete("name");
        assertEquals("2 persons with name \"name\" was deleted.", result);
    }

    @Test
    void deleteZeroTest() {
        MainController mainController = new MainController();
        String name = mainController.delete("name");
        assertEquals("0 persons with name \"name\" was deleted.", name);
    }

    @Test
    void listCountTest() {
        MainController mainController = new MainController();
        mainController.crete("name");
        mainController.crete("name");
        String result = mainController.list("name");
        assertEquals("2 persons with name \"name\" was found.", result);
    }

    @Test
    void listZeroTest() {
        MainController mainController = new MainController();
        String result = mainController.list("name");
        assertEquals("0 persons with name \"name\" was found.", result);
    }
}