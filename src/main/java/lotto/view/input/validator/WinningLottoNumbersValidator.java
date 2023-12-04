package lotto.view.input.validator;

import static lotto.view.input.constant.InputSymbolConstant.WINNING_LOTTO_NUMBER_DELIMITER;

public class WinningLottoNumbersValidator implements NotEmptyCheckable, ContainingDelimiterCheckable,
        NotDuplicatedCheckable {

    public void validate(String userInput) {
        validateIsNotEmpty(userInput);
        validateContainsDelimiter(userInput);
        validateIsNotStartsWithOrEndWithDelimiter(userInput);
        validateNotDuplicated(userInput, WINNING_LOTTO_NUMBER_DELIMITER.getSymbol());
    }
}