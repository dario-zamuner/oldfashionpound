package it.dariozamuner.operation.factories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;


class AdditionFactoryTest {

    @Test
    @DisplayName("The input matches the addition operation")
    void buildOk() {
        final AdditionFactory additionFactory = new AdditionFactory();
        assertNotNull(additionFactory.build("5p 17s 8d + 3p 4s 10d"));
    }

    @Test
    @DisplayName("The input matches the addition operation even if some input is missing")
    void buildOkPartialInput() {
        final AdditionFactory additionFactory = new AdditionFactory();
        assertNotNull(additionFactory.build("5p 1s + 19s 10d"));
    }

    @Test
    @DisplayName("The input doesn't match the addition operation")
    void buildKoWrongInput() {
        final AdditionFactory additionFactory = new AdditionFactory();
        assertNull(additionFactory.build("5p 17s 8d - 3p 4s 10d"));
    }
}