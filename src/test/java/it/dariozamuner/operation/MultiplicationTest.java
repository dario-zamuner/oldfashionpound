package it.dariozamuner.operation;

import it.dariozamuner.dtos.CurrencyAmount;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {

    @Test
    @DisplayName("The result is right")
    void executeOk() {
        final Multiplication multiplication = new Multiplication(new CurrencyAmount(5, 17, 8),
                2);
        MatcherAssert.assertThat("Output is right", multiplication.execute(),
                is(new CurrencyAmount(11, 15, 4)));
    }
}