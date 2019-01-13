package it.dariozamuner.utils;

import it.dariozamuner.dtos.CurrencyAmount;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ConvertUtils {
    private static final Pattern notDigits = Pattern.compile("[^0-9]");

    /**
     * Extracts the integer part from a string
     *
     * @param input the string containing an integer
     * @return the integer extracted from the string
     */
    public static Integer extractInteger(final String input) {
        if (StringUtils.isNotBlank(input)) {
            return Integer.valueOf(notDigits.matcher(input).replaceAll(""));
        }
        return 0;
    }

    /**
     * Converts a {@link CurrencyAmount} in pennies
     *
     * @param currencyAmount the input value
     * @return the number of corresponding pennies
     */
    public static Integer currencyAmountToPennies(final CurrencyAmount currencyAmount) {
        return 20 * 12 * currencyAmount.getPounds() + 12 * currencyAmount.getShillings() + currencyAmount.getPennies();
    }

    /**
     * Converts a number representing pennies into a {@link CurrencyAmount}
     *
     * @param pennies the number of pennies to be converted
     * @return a {@link CurrencyAmount} corresponding to the given number of pennies
     */
    public static CurrencyAmount penniesToCurrencyAmount(final Integer pennies) {
        return new CurrencyAmount(pennies / 240, (pennies / 12) % 20, pennies % 12);
    }
}
