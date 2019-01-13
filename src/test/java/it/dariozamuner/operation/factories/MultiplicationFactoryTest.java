package it.dariozamuner.operation.factories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationFactoryTest {

    @Test
    @DisplayName("The input matches the multiplication operation")
    void buildOk() {
        final MultiplicationFactory multiplicationFactory = new MultiplicationFactory();
        assertNotNull(multiplicationFactory.build("5p 17s 8d * 2"));
    }

    @Test
    @DisplayName("The input matches the multiplication operation even if some input is missing")
    void buildOkPartialInput() {
        final MultiplicationFactory multiplicationFactory = new MultiplicationFactory();
        assertNotNull(multiplicationFactory.build("5p 1s * 40"));
    }

    @Test
    @DisplayName("The input doesn't match the multiplication operation")
    void buildKoWrongInput() {
        final MultiplicationFactory multiplicationFactory = new MultiplicationFactory();
        assertNull(multiplicationFactory.build("5p 17s 8d * 3p 4s 10d"));
    }
}