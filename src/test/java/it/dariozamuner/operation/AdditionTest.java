package it.dariozamuner.operation;

import it.dariozamuner.dtos.CurrencyAmount;
import it.dariozamuner.operation.factories.AdditionFactory;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

class AdditionTest {

    @Test
    @DisplayName("The result is right")
    void executeOk() {
        final Addition addition = new Addition(new CurrencyAmount(5, 17, 8),
                new CurrencyAmount(3, 4, 10));
        MatcherAssert.assertThat("Output is right", addition.execute(),
                is(new CurrencyAmount(9, 2, 6)));
    }
}