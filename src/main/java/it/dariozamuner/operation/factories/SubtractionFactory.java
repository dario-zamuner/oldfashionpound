package it.dariozamuner.operation.factories;

import it.dariozamuner.dtos.CurrencyAmount;
import it.dariozamuner.operation.Addition;
import it.dariozamuner.operation.Subtraction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Factory class for {@link Subtraction}.
 * See {@link OperationFactory}
 */
public class SubtractionFactory implements OperationFactory {

    private final Pattern subtractionPattern =
            Pattern.compile("^([-]?[0-9]*p)? ?([-]?[0-9]*s)? ?([-]?[0-9]*d)? ? - ([-]?[0-9]*p)? ?([-]?[0-9]*s)? ?([-]?[0-9]*d)?$");

    public Subtraction build(final String inputString) {
        final Matcher matcher = subtractionPattern.matcher(inputString);
        if (matcher.find()) {
            CurrencyAmount firstOperand = extractCurrencyAmount(matcher.group(1), matcher.group(2), matcher.group(3));
            CurrencyAmount secondOperand = extractCurrencyAmount(matcher.group(4), matcher.group(5), matcher.group(6));
            return new Subtraction(firstOperand, secondOperand);
        }
        return null;
    }
}
