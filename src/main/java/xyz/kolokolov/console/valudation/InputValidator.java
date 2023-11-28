package xyz.kolokolov.console.valudation;

import java.util.regex.Pattern;

public class InputValidator {
    private final Pattern pattern = Pattern.compile("^(\\bcreate|delete|list\\b)\\s(\\b\\w+\\b)$");

    public boolean validate(String input) {
        return pattern.matcher(input.toLowerCase())
                .matches();
    }
}
