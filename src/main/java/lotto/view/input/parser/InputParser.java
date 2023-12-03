package lotto.view.input.parser;


import static lotto.view.input.constant.InputSymbolConstant.BLANK;
import static lotto.view.input.constant.InputSymbolConstant.VOID;

import java.util.Arrays;
import java.util.List;
import lotto.view.input.validator.UserMoneyInputValidator;

public class InputParser {
    // 각 Input Validator 선언
    private final UserMoneyInputValidator userMoneyInputValidator;

    // 각 Input Validator 생성
    public InputParser() {
        userMoneyInputValidator = new UserMoneyInputValidator();
    }

    public long parseToUserMoney(String userInput) {
        userInput = removeBlank(userInput);
        userMoneyInputValidator.validate(userInput);
        return parseToLong(userInput);
    }

    private List<String> parseToStrings(String userInput) {
        return Arrays.stream(userInput.split(","))
                .toList();
    }

    private long parseToLong(String userInput) {
        return Long.parseLong(userInput);
    }

    private String removeBlank(String userInput) {
        if (userInput.contains(BLANK.getSymbol())) {
            userInput = userInput.replace(BLANK.getSymbol(), VOID.getSymbol());
        }
        return userInput;
    }
}