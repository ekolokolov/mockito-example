package xyz.kolokolov.console.model;

public record Request(
        Command command,
        String value
) {
}
