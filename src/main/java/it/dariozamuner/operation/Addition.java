package it.dariozamuner.operation;

import it.dariozamuner.dtos.CurrencyAmount;
import it.dariozamuner.utils.ConvertUtils;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

/**
 * Addition operation
 */
@RequiredArgsConstructor
public class Addition implements Operation {

    @Valid
    private final CurrencyAmount firstOperand;
    @Valid
    private final CurrencyAmount secondOperand;

    /**
     * Convert both operands to pennies, add each other and convert the result to a {@link CurrencyAmount}
     * @return the addition result
     */
    public CurrencyAmount execute() {
        final Integer penniesFirstOperand = ConvertUtils.currencyAmountToPennies(firstOperand);
        final Integer penniesSecondOperand = ConvertUtils.currencyAmountToPennies(secondOperand);
        return ConvertUtils.penniesToCurrencyAmount(penniesFirstOperand + penniesSecondOperand);
    }
}
