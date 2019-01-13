package it.dariozamuner.operation;

import it.dariozamuner.dtos.CurrencyAmount;
import it.dariozamuner.utils.ConvertUtils;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Multiplication operation
 */
@RequiredArgsConstructor
public class Multiplication implements Operation {

    @Valid
    private final CurrencyAmount firstOperand;
    @NotNull
    private final Integer secondOperand;

    /**
     * Convert the first operand to pennies, multiplies them by the second operand
     * and convert the result to a {@link CurrencyAmount}
     *
     * @return the multiplication result
     */
    public CurrencyAmount execute() {
        final Integer penniesFirstOperand = ConvertUtils.currencyAmountToPennies(firstOperand);
        return ConvertUtils.penniesToCurrencyAmount(penniesFirstOperand * secondOperand);
    }
}
