package it.dariozamuner.operation.factories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionFactoryTest {

    @Test
    @DisplayName("The input matches the subtraction operation")
    void buildOk() {
        final SubtractionFactory subtractionFactory = new SubtractionFactory();
        assertNotNull(subtractionFactory.build("5p 17s 8d - 3p 4s 10d"));
    }

    @Test
    @DisplayName("The input matches the subtraction operation even if some input is missing")
    void buildOkPartialInput() {
        final SubtractionFactory subtractionFactory = new SubtractionFactory();
        assertNotNull(subtractionFactory.build("5p 1s - 19s 10d"));
    }

    @Test
    @DisplayName("The input doesn't match the subtraction operation")
    void buildKoWrongInput() {
        final SubtractionFactory subtractionFactory = new SubtractionFactory();
        assertNull(subtractionFactory.build("5p 17s 8d + 3p 4s 10d"));
    }
}