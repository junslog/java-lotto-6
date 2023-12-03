package lotto.view.input.parser;


import static lotto.view.input.constant.InputSymbolConstant.BLANK;
import static lotto.view.input.constant.InputSymbolConstant.VOID;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    // 각 Input Validator 선언

    // 각 Input Validator 생성
    public InputParser() {

    }

    private List<String> parseToStrings(String userInput) {
        return Arrays.stream(userInput.split(","))
                .toList();
    }

    private int parseToInt(String userInput) {
        return Integer.parseInt(userInput);
    }

    private String removeBlank(String userInput) {
        if (userInput.contains(BLANK.getSymbol())) {
            userInput = userInput.replace(BLANK.getSymbol(), VOID.getSymbol());
        }
        return userInput;
    }
}