package it.dariozamuner;

import it.dariozamuner.dtos.CurrencyAmount;
import it.dariozamuner.operation.Addition;
import it.dariozamuner.operation.factories.AdditionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationManagerTest {

    @Test
    @DisplayName("The result is right")
    void executeOk() {
        final String input = "5p 17s 8d + 3p 4s 10d";
        final AdditionFactory additionFactory = Mockito.mock(AdditionFactory.class);
        final Addition addition = Mockito.mock(Addition.class);

        Mockito.when(additionFactory.build(input)).thenReturn(addition);
        Mockito.when(addition.execute()).thenReturn(new CurrencyAmount(9, 2, 6));
        final OperationManager operationManager = new OperationManager(Collections.singletonList(additionFactory));
        assertThat(operationManager.execute(input), is("9p 2s 6d"));
    }

    @Test
    @DisplayName("No operation is matching the input")
    void executeKo() {
        final String input = "5p 17s 8d + 3";
        final AdditionFactory additionFactory = Mockito.mock(AdditionFactory.class);
        final Addition addition = Mockito.mock(Addition.class);

        Mockito.when(additionFactory.build(input)).thenReturn(null);

        final OperationManager operationManager = new OperationManager(Collections.singletonList(additionFactory));
        final IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> operationManager.execute(input));
        assertThat("Exception's message is right", illegalArgumentException.getMessage(),
                is("Input format not supported"));
    }
}