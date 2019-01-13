package it.dariozamuner.operation.factories;

import it.dariozamuner.dtos.CurrencyAmount;
import it.dariozamuner.operation.Addition;
import it.dariozamuner.operation.Division;
import it.dariozamuner.utils.ConvertUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Factory class for {@link Division}.
 * See {@link OperationFactory}
 */
public class DivisionFactory implements OperationFactory {

    private final Pattern divisionPattern = Pattern.compile("^([-]?[0-9]*p)? ?([-]?[0-9]*s)? ?([-]?[0-9]*d)? ? / ([-]?[0-9]*)$");

    public Division build(final String inputString) {
        final Matcher matcher = divisionPattern.matcher(inputString);
        if (matcher.find()) {
            CurrencyAmount firstOperand = extractCurrencyAmount(matcher.group(1), matcher.group(2), matcher.group(3));
            return new Division(firstOperand, ConvertUtils.extractInteger(matcher.group(4)));
        }
        return null;
    }
}
