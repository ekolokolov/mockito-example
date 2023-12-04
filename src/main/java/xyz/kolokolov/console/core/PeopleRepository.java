package xyz.kolokolov.console.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Репозиторий представляет из себя "хранилище данных"
 */
public class PeopleRepository {

    private final Map<String, Integer> store = new HashMap<>();

    public int create(String name) {
        Integer count = store.getOrDefault(name, 0);
        store.put(name, ++count);
        return count;
    }

    public int find(String name) {
        return store.getOrDefault(name, 0);
    }

    public int delete(String name) {
        Integer value = store.remove(name);
        return value != null ? value : 0;
    }
}
