package lotto.view.input.parser;


import static lotto.view.input.constant.InputSymbolConstant.BLANK;
import static lotto.view.input.constant.InputSymbolConstant.VOID;
import static lotto.view.input.constant.InputSymbolConstant.WINNING_LOTTO_NUMBER_DELIMITER;

import java.util.Arrays;
import java.util.List;
import lotto.view.input.validator.BonusNumberValidator;
import lotto.view.input.validator.UserMoneyInputValidator;
import lotto.view.input.validator.WinningLottoNumberValidator;
import lotto.view.input.validator.WinningLottoNumbersValidator;

public class InputParser {
    // 각 Input Validator 선언
    private final UserMoneyInputValidator userMoneyInputValidator;
    private final WinningLottoNumbersValidator winningLottoNumbersValidator;
    private final WinningLottoNumberValidator winningLottoNumberValidator;
    private final BonusNumberValidator bonusNumberValidator;

    public InputParser() {
        this.userMoneyInputValidator = new UserMoneyInputValidator();
        this.winningLottoNumbersValidator = new WinningLottoNumbersValidator();
        this.winningLottoNumberValidator = new WinningLottoNumberValidator();
        this.bonusNumberValidator = new BonusNumberValidator();
    }

    public long parseToUserMoney(String userInput) {
        userInput = removeBlank(userInput);
        userMoneyInputValidator.validate(userInput);
        return parseToLong(userInput);
    }

    public List<Integer> parseToWinningLottoNumbers(String userInput) {
        userInput = removeBlank(userInput);
        winningLottoNumbersValidator.validate(userInput);
        validateEachWinningLottoNumber(userInput);
        return parseToInts(userInput);
    }

    public int parseToBonusNumber(String userInput) {
        userInput = removeBlank(userInput);
        bonusNumberValidator.validate(userInput);
        return parseToInt(userInput);
    }

    private List<Integer> parseToInts(String userInput) {
        return Arrays.stream(userInput.split(WINNING_LOTTO_NUMBER_DELIMITER.getSymbol()))
                .mapToInt(this::parseToInt)
                .boxed()
                .toList();
    }

    private int parseToInt(String userInput) {
        return Integer.parseInt(userInput);
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

    private void validateEachWinningLottoNumber(String userInput) {
        Arrays.stream(userInput.split(WINNING_LOTTO_NUMBER_DELIMITER.getSymbol()))
                .forEach(winningLottoNumberValidator::validate);
    }
}