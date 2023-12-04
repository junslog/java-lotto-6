package lotto.view.input.validator;

import static lotto.view.input.exception.InputExceptionMessage.INPUT_HAS_DUPLICATED_VALUES;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.view.input.exception.InputException;

public interface NotDuplicatedCheckable {
    default void validateNotDuplicated(String userInput, String elementDelimiter) {
        if (isDuplicated(userInput, elementDelimiter)) {
            throw InputException.of(INPUT_HAS_DUPLICATED_VALUES.getMessage());
        }
    }

    private boolean isDuplicated(String userInput, String elementDelimiter) {
        List<String> elements = Arrays.stream(userInput.split(elementDelimiter))
                .toList();
        return new HashSet<>(elements)
                .size() < elements.size();
    }
}