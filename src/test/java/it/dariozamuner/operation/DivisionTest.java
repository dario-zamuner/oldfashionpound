package it.dariozamuner.operation;

import it.dariozamuner.dtos.CurrencyAmount;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

class DivisionTest {
    @Test
    @DisplayName("The result is right")
    void executeOk() {
        final Division division = new Division(new CurrencyAmount(5, 17, 8),
                3);
        final CurrencyAmount currencyAmount = new CurrencyAmount(1, 19, 2);
        currencyAmount.setRemainder(2);
        MatcherAssert.assertThat("Output is right", division.execute(), is(currencyAmount));
    }
}