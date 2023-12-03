package lotto.view.input.validator;

import static lotto.view.input.constant.InputSymbolConstant.WINNING_LOTTO_NUMBER_DELIMITER;
import static lotto.view.input.exception.InputExceptionMessage.CONTAINS_EMPTY_INPUT;
import static lotto.view.input.exception.InputExceptionMessage.INPUT_DOES_NOT_CONTAIN_DELIMITER;

import lotto.view.input.exception.InputException;


public interface ContainingDelimiterCheckable {
    default void validateContainsDelimiter(String userInput) {
        if (!userInput.contains(WINNING_LOTTO_NUMBER_DELIMITER.getSymbol())) {
            throw InputException.of(INPUT_DOES_NOT_CONTAIN_DELIMITER.getMessage());
        }
    }

    default void validateIsNotStartsWithOrEndWithDelimiter(String userInput) {
        if (userInput.startsWith(WINNING_LOTTO_NUMBER_DELIMITER.getSymbol()) || userInput.endsWith(
                WINNING_LOTTO_NUMBER_DELIMITER.getSymbol())) {
            throw InputException.of(CONTAINS_EMPTY_INPUT.getMessage());
        }
    }
}