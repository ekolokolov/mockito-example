package xyz.kolokolov.console.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeopleRepositoryTest {

    private PeopleRepository sut;

    @BeforeEach
    void setUp() {
        this.sut = new PeopleRepository();
    }

    @Test
    void create() {
        assertEquals(1, sut.create("test"));
        assertEquals(2, sut.create("test"));
        assertEquals(1, sut.create("test-other"));
        assertEquals(2, sut.create("test-other"));
        assertEquals(3, sut.create("test"));
    }

    @Test
    void find() {
        assertEquals(0, sut.find("test"));
        assertEquals(1, sut.create("test"));
        assertEquals(1, sut.find("test"));
        assertEquals(1, sut.create("test-other"));
        assertEquals(2, sut.create("test-other"));
        assertEquals(2, sut.find("test-other"));
    }

    @Test
    void delete() {
        assertEquals(0, sut.delete("test"));
        assertEquals(1, sut.create("test"));
        assertEquals(1, sut.delete("test"));
        assertEquals(1, sut.create("test-other"));
        assertEquals(2, sut.create("test-other"));
        assertEquals(2, sut.delete("test-other"));
    }
}