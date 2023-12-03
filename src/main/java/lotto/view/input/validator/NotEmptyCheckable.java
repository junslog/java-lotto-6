package lotto.view.input.validator;

import lotto.view.input.exception.InputException;
import lotto.view.input.exception.InputExceptionMessage;

public interface NotEmptyCheckable {
    default void validateIsNotEmpty(String userInput) {
        if (userInput.isBlank()) {
            throw InputException.of(InputExceptionMessage.IS_EMPTY.getMessage());
        }
    }
}