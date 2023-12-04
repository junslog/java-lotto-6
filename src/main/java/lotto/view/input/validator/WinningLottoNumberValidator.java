package lotto.view.input.validator;

public class WinningLottoNumberValidator implements NotEmptyCheckable, PositiveNumericCheckable {
    public void validate(String userInput) {
        validateIsNotEmpty(userInput);
        validateIsNumeric(userInput);
        validateIsPositive(userInput);
    }
}