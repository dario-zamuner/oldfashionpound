package it.dariozamuner.operation.factories;

import it.dariozamuner.dtos.CurrencyAmount;
import it.dariozamuner.operation.Operation;
import it.dariozamuner.utils.ConvertUtils;

/**
 * Every class implementing this interface can instantiate an {@link Operation} parsing the input string.
 * If the input doesn't match the expected format it returns null.
 */
public interface OperationFactory {

    Operation build(String inputString);

    default CurrencyAmount extractCurrencyAmount(final String pounds, final String shillings, final String pennies) {
        return new CurrencyAmount(ConvertUtils.extractInteger(pounds),
                ConvertUtils.extractInteger(shillings),
                ConvertUtils.extractInteger(pennies));
    }
}
