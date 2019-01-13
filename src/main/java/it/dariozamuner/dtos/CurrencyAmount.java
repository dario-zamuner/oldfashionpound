package it.dariozamuner.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@RequiredArgsConstructor
public class CurrencyAmount {
    private final Integer pounds;
    @Max(19)
    @Min(-19)
    private final Integer shillings;
    @Max(11)
    @Min(-11)
    private final Integer pennies;
    private Integer remainder;

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder(String.format("%dp %ds %dd", pounds, shillings, pennies));
        if(remainder != null && remainder != 0){
            stringBuilder.append(String.format(" - %da", remainder));
        }
        return stringBuilder.toString();
    }
}
