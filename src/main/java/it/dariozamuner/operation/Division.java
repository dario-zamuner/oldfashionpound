package it.dariozamuner.operation;

import it.dariozamuner.dtos.CurrencyAmount;
import it.dariozamuner.utils.ConvertUtils;
import it.dariozamuner.validation.NotZeroValidator;
import it.dariozamuner.validation.NotZeroValidator.NotZero;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Division operation
 */
@RequiredArgsConstructor
public class Division implements Operation {

    @Valid
    private final CurrencyAmount firstOperand;
    @NotZero
    private final Integer secondOperand;

    /**
     * Convert the first operand to pennies, divide them by the second operand
     * and convert the result to a {@link CurrencyAmount}, adding at last the remainder
     * @return the division result
     */
    public CurrencyAmount execute() {
        final Integer penniesFirstOperand = ConvertUtils.currencyAmountToPennies(firstOperand);
        final CurrencyAmount currencyAmount = ConvertUtils.penniesToCurrencyAmount(penniesFirstOperand / secondOperand);
        currencyAmount.setRemainder(penniesFirstOperand % secondOperand);
        return currencyAmount;
    }
}
