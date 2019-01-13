package it.dariozamuner.operation.factories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

class DivisionFactoryTest {
    @Test
    @DisplayName("The input matches the division operation")
    void buildOk() {
        final DivisionFactory divisionFactory = new DivisionFactory();
        assertNotNull(divisionFactory.build("5p 17s 8d / 3"));
    }

    @Test
    @DisplayName("The input matches the division operation even if some input is missing")
    void buildOkPartialInput() {
        final DivisionFactory divisionFactory = new DivisionFactory();
        assertNotNull(divisionFactory.build("5p 1s / 40"));
    }

    @Test
    @DisplayName("The input doesn't match the division operation")
    void buildKoWrongInput() {
        final DivisionFactory divisionFactory = new DivisionFactory();
        assertNull(divisionFactory.build("5p 17s 8d / 3p 4s 10d"));
    }
}