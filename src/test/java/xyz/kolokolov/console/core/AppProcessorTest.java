package xyz.kolokolov.console.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AppProcessorTest {

    @Test
    void processWrongTest() {
        AppProcessor appProcessor = new AppProcessor();
        String result = appProcessor.process("create hello");
        assertEquals("Person hello - 1's was created.", result);
    }

}