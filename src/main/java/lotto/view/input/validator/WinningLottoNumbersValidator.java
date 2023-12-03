package lotto.view.input.validator;

public class WinningLottoNumbersValidator implements NotEmptyCheckable, ContainingDelimiterCheckable {

    public void validate(String userInput) {
        validateIsNotEmpty(userInput);
        validateContainsDelimiter(userInput);
        validateIsNotStartsWithOrEndWithDelimiter(userInput);
    }
}