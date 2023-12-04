package lotto.view.input.validator;

public class UserMoneyInputValidator implements NotEmptyCheckable, PositiveNumericCheckable {
    public void validate(String userInput) {
        validateIsNotEmpty(userInput);
        validateIsNumeric(userInput);
        validateIsPositive(userInput);
    }
}