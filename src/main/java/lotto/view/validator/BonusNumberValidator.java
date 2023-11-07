package lotto.view.validator;

import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class BonusNumberValidator {
    public void validate(String userInput) {
        isNotEmpty(userInput);
        isNotNumeric(userInput);
    }

    private void isNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw LottoInputException.of(LottoInputExceptionMessage.INPUT_IS_EMPTY);
        }
    }

    private void isNotNumeric(String userInput) {
        try {
            Long.parseLong(userInput);
        } catch (NumberFormatException e) {
            throw LottoInputException.of(LottoInputExceptionMessage.BONUS_NUMBER_IS_NOT_NUMERIC_TYPE);
        }
    }
}