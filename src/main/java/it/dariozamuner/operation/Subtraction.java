package it.dariozamuner.operation;

import it.dariozamuner.dtos.CurrencyAmount;
import it.dariozamuner.utils.ConvertUtils;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

/**
 * Subtraction operation
 */
@RequiredArgsConstructor
public class Subtraction implements Operation {

    @Valid
    private final CurrencyAmount firstOperand;
    @Valid
    private final CurrencyAmount secondOperand;

    /**
     * Convert both operands to pennies, subtract the second from the first
     * and convert the result to a {@link CurrencyAmount}
     *
     * @return the subtraction result
     */
    public CurrencyAmount execute() {
        final Integer penniesFirstOperand = ConvertUtils.currencyAmountToPennies(firstOperand);
        final Integer penniesSecondOperand = ConvertUtils.currencyAmountToPennies(secondOperand);
        return ConvertUtils.penniesToCurrencyAmount(penniesFirstOperand - penniesSecondOperand);
    }
}
