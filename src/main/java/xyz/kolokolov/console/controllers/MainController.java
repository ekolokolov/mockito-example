package xyz.kolokolov.console.controllers;

import xyz.kolokolov.console.core.PeopleRepository;

public class MainController {

    private final PeopleRepository peopleRepository;

    public MainController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public String crete(String request) {
        int count = peopleRepository.create(request);
        return "Person %s - %d's was created.".formatted(request, count);
    }

    public String delete(String request) {
        int count = peopleRepository.delete(request);
        return "%d persons with name \"%s\" was deleted.".formatted(count, request);
    }

    public String list(String request) {
        int count = peopleRepository.find(request);
        return "%d persons with name \"%s\" was found.".formatted(count, request);

    }
}