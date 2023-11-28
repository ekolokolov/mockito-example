package xyz.kolokolov.console.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeopleRepositoryTest {

    @Test
    void create() {
        PeopleRepository repository = new PeopleRepository();
        assertEquals(1, repository.create("test"));
        assertEquals(2, repository.create("test"));
        assertEquals(1, repository.create("test-other"));
        assertEquals(2, repository.create("test-other"));
        assertEquals(3, repository.create("test"));
    }

    @Test
    void find() {
        PeopleRepository repository = new PeopleRepository();
        assertEquals(0, repository.find("test"));
        assertEquals(1, repository.create("test"));
        assertEquals(1, repository.find("test"));
        assertEquals(1, repository.create("test-other"));
        assertEquals(2, repository.create("test-other"));
        assertEquals(2, repository.find("test-other"));
    }

    @Test
    void delete() {
        PeopleRepository repository = new PeopleRepository();
        assertEquals(0, repository.delete("test"));
        assertEquals(1, repository.create("test"));
        assertEquals(1, repository.delete("test"));
        assertEquals(1, repository.create("test-other"));
        assertEquals(2, repository.create("test-other"));
        assertEquals(2, repository.delete("test-other"));
    }
}