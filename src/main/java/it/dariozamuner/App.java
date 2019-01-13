package it.dariozamuner;

import it.dariozamuner.operation.factories.AdditionFactory;
import it.dariozamuner.operation.factories.DivisionFactory;
import it.dariozamuner.operation.factories.MultiplicationFactory;
import it.dariozamuner.operation.factories.SubtractionFactory;

import java.util.Arrays;

/**
 * This app is able to execute the 4 binary operation addition, subtraction, division and multiplication
 * in the old english monetary system context
 */
public class App {
    public static void main(String[] args) {
        // Check if a parameter exists
        if (args.length < 1) {
            throw new IllegalArgumentException(
                    String.format("No parameter specified. Please add a parameter, i.e. '%s'",
                            "5p 17s 8d + 3p 4s 10d"));
        }
        // Init the operationManager with the operations needed
        final OperationManager operationManager = new OperationManager(Arrays.asList(
                new AdditionFactory(),
                new SubtractionFactory(),
                new MultiplicationFactory(),
                new DivisionFactory()));
        final String result = operationManager.execute(args[0]);
        // Print the result to console
        System.out.println(String.format("%s = %s", args[0], result));
    }
}
