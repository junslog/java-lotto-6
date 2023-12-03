package lotto.view.output;

import static lotto.view.output.constant.OutputFormatConstant.PRINT_NUMBER_OF_LOTTOS_BOUGHT_FORMAT;
import static lotto.view.output.constant.OutputMessageConstant.ASK_TO_INSERT_BONUS_NUMBER;
import static lotto.view.output.constant.OutputMessageConstant.ASK_TO_INSERT_LOTTO_MONEY;
import static lotto.view.output.constant.OutputMessageConstant.ASK_TO_INSERT_WINNING_LOTTO_NUMBERS;
import static lotto.view.output.constant.OutputSymbolConstant.LOTTO_NUMBER_JOINING_DELIMITER;
import static lotto.view.output.constant.OutputSymbolConstant.LOTTO_NUMBER_OUTPUT_LEFT_BRACE;
import static lotto.view.output.constant.OutputSymbolConstant.LOTTO_NUMBER_OUTPUT_RIGHT_BRACE;
import static lotto.view.output.constant.OutputSymbolConstant.NEW_LINE;

import java.util.stream.Collectors;
import lotto.dto.BoughtLottoNumbersDtos;

public class OutputView {

    public void askToInsertMoney() {
        print(ASK_TO_INSERT_LOTTO_MONEY.getMessage());
        printLine();
    }

    public void printError(String message) {
        print(message);
        printLine();
    }

    public void printUserLottos(BoughtLottoNumbersDtos boughtLottoNumbersDtos) {
        printLine();

        print(String.format(PRINT_NUMBER_OF_LOTTOS_BOUGHT_FORMAT.getFormat(),
                boughtLottoNumbersDtos.boughtLottoNumbers()));
        printLine();
        boughtLottoNumbersDtos.boughtLottoNumbersDtos().forEach(
                boughtLottoNumbersDto -> {
                    print(LOTTO_NUMBER_OUTPUT_LEFT_BRACE.getSymbol());
                    print(boughtLottoNumbersDto.lottoNumbers().stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(LOTTO_NUMBER_JOINING_DELIMITER.getSymbol())));
                    print(LOTTO_NUMBER_OUTPUT_RIGHT_BRACE.getSymbol());
                    printLine();
                }
        );
    }

    public void askToInsertWinningLottoNumbers() {
        printLine();
        print(ASK_TO_INSERT_WINNING_LOTTO_NUMBERS.getMessage());
        printLine();
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void printLine() {
        print(NEW_LINE.getSymbol());
    }


    public void askToInsertBonusNumber() {
        printLine();
        print(ASK_TO_INSERT_BONUS_NUMBER.getMessage());
        printLine();
    }
}
