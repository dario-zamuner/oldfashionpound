package it.dariozamuner;

import it.dariozamuner.operation.factories.AdditionFactory;
import it.dariozamuner.operation.factories.DivisionFactory;
import it.dariozamuner.operation.factories.MultiplicationFactory;
import it.dariozamuner.operation.factories.SubtractionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OperationManagerFunctionalTest {

    @Test
    @DisplayName("Right result for addition")
    void executeOkAddition() {
        final OperationManager operationManager = new OperationManager(Collections.singletonList(new AdditionFactory()));
        assertThat(operationManager.execute("5p 17s 8d + 3p 4s 10d"), is("9p 2s 6d"));
    }

    @Test
    @DisplayName("Right result for subtraction")
    void executeOkSubtraction() {
        final OperationManager operationManager = new OperationManager(Collections.singletonList(new SubtractionFactory()));
        assertThat(operationManager.execute("5p 17s 8d - 3p 4s 10d"), is("2p 12s 10d"));
    }

    @Test
    @DisplayName("Right result for multiplication")
    void executeOkMultiplication() {
        final OperationManager operationManager = new OperationManager(Collections.singletonList(new MultiplicationFactory()));
        assertThat(operationManager.execute("5p 17s 8d * 2"), is("11p 15s 4d"));
    }

    @Test
    @DisplayName("Right result for division")
    void executeOkDivision() {
        final OperationManager operationManager = new OperationManager(Collections.singletonList(new DivisionFactory()));
        assertThat(operationManager.execute("5p 17s 8d / 3"), is("1p 19s 2d - 2a"));
    }

    @Test
    @DisplayName("No operation is matching the input")
    void executeKo() {
        final OperationManager operationManager = new OperationManager(Collections.singletonList(new AdditionFactory()));
        final IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> operationManager.execute("5p 17s 8d + 3"));
        assertThat("Invalid input format", illegalArgumentException.getMessage(),
                is("Input format not supported"));
    }

    @Test
    @DisplayName("Division by zero")
    void executeKoDivisionByZero() {
        final OperationManager operationManager = new OperationManager(Collections.singletonList(new DivisionFactory()));
        assertThrows(ValidationException.class, () -> operationManager.execute("5p 17s 8d / 0"));
    }

    @Test
    @DisplayName("Invalid shillings and pennies number in the input string")
    void executeKoInvalidInput() {
        final OperationManager operationManager = new OperationManager(Collections.singletonList(new AdditionFactory()));
        final ValidationException validationException = assertThrows(ValidationException.class,
                () -> operationManager.execute("5p 20s 13d + 3p 4s 10d"));
        assertTrue(validationException.getMessage().contains("shillings"));
        assertTrue(validationException.getMessage().contains("pennies"));
    }
}