package it.dariozamuner.operation;

import it.dariozamuner.dtos.CurrencyAmount;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class SubtractionTest {

    @Test
    @DisplayName("The result is right")
    void executeOk() {
        final Subtraction subtraction = new Subtraction(new CurrencyAmount(5, 17, 8),
                new CurrencyAmount(3, 4, 10));
        MatcherAssert.assertThat("Output is right", subtraction.execute(),
                is(new CurrencyAmount(2, 12, 10)));
    }

    @Test
    @DisplayName("The result is right even if it's negative")
    void executeOkNegativeAmount() {
        final Subtraction subtraction = new Subtraction(new CurrencyAmount(5, 7, 0),
                new CurrencyAmount(10, 5, 7));
        MatcherAssert.assertThat("Output is right", subtraction.execute(),
                is(new CurrencyAmount(-4, -18, -7)));
    }
}