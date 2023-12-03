package lotto.view.input.validator;

public class BonusNumberValidator implements NotEmptyCheckable, PositiveNumericCheckable {
    public void validate(String userInput) {
        validateIsNotEmpty(userInput);
        validateIsNumeric(userInput);
        validateIsPositive(userInput);
    }
}
