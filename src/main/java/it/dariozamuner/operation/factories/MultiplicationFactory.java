package it.dariozamuner.operation.factories;

import it.dariozamuner.dtos.CurrencyAmount;
import it.dariozamuner.operation.Addition;
import it.dariozamuner.operation.Multiplication;
import it.dariozamuner.utils.ConvertUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Factory class for {@link Multiplication}.
 * See {@link OperationFactory}
 */
public class MultiplicationFactory implements OperationFactory {

    private final Pattern multiplicationPattern =
            Pattern.compile("^([-]?[0-9]*p)? ?([-]?[0-9]*s)? ?([-]?[0-9]*d)? ? \\* ([-]?[0-9]*)$");

    public Multiplication build(final String inputString) {
        final Matcher matcher = multiplicationPattern.matcher(inputString);
        if (matcher.find()) {
            CurrencyAmount firstOperand = extractCurrencyAmount(matcher.group(1), matcher.group(2), matcher.group(3));
            return new Multiplication(firstOperand, ConvertUtils.extractInteger(matcher.group(4)));
        }
        return null;
    }
}
