package xyz.kolokolov.console.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import xyz.kolokolov.console.valudation.InputValidator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class InputValidatorTest {

    @ParameterizedTest
    @MethodSource("dataSource")
    void validationTest(boolean expected, String input) {
        InputValidator inputValidator = new InputValidator();
        boolean result = inputValidator.validate(input);
        assertEquals(expected, result);
    }

    static Stream<Arguments> dataSource() {
        return Stream.of(
                of(true, "create test"),
                of(true, "delete test"),
                of(true, "list test"),
                of(false, " update test"),
                of(false, "create  test"),
                of(false, "delete test "),
                of(false, "crete test"),
                of(false, "crete test1"),
                of(false, "crete 1"),
                of(false, "test create"),
                of(false, "crete test ok")
        );
    }
}