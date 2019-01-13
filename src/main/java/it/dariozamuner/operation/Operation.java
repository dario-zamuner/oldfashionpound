package it.dariozamuner.operation;

import it.dariozamuner.dtos.CurrencyAmount;

/**
 * Every class implementing this interface should calculate a result starting from its internal state
 */
public interface Operation {
    /**
     * This method executes the operations needed to calculate the result
     * @return the result
     */
    CurrencyAmount execute();
}
