package it.dariozamuner;

import it.dariozamuner.operation.Operation;
import it.dariozamuner.operation.factories.OperationFactory;
import it.dariozamuner.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class job is
 * <ul>
 *     <li>
 *         call every {@link OperationFactory} until one of them returns an {@link Operation},
 *         meaning that the input was correctly parsed.
 *     </li>
 *     <li>
 *         validate operation content
 *     </li>
 *     <li>
 *         call the operation method to return the result
 *     </li>
 * </ul>
 */
public class OperationManager {
    private final List<OperationFactory> operationFactories = new ArrayList<>();
    private final Validator validator = new Validator();

    OperationManager(final List<OperationFactory> operationFactories) {
        this.operationFactories.addAll(operationFactories);
    }

    public String execute(final String inputString) {
        final Operation operation = operationFactories.stream()
                .map(operationFactory -> operationFactory.build(inputString)
                ).filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Input format not supported"));
        validator.validate(operation);
        return operation.execute().toString();
    }
}
