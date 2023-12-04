package lotto.view.output;

import static lotto.domain.LottoResult.FIFTH_RANK;
import static lotto.domain.LottoResult.FIRST_RANK;
import static lotto.domain.LottoResult.FOURTH_RANK;
import static lotto.domain.LottoResult.SECOND_RANK;
import static lotto.domain.LottoResult.THIRD_RANK;
import static lotto.view.output.constant.OutputFormatConstant.PRINT_FIFTH_RANK;
import static lotto.view.output.constant.OutputFormatConstant.PRINT_FIRST_RANK;
import static lotto.view.output.constant.OutputFormatConstant.PRINT_FOURTH_RANK;
import static lotto.view.output.constant.OutputFormatConstant.PRINT_NUMBER_OF_LOTTOS_BOUGHT_FORMAT;
import static lotto.view.output.constant.OutputFormatConstant.PRINT_RATE_OF_RETURN_FORMAT;
import static lotto.view.output.constant.OutputFormatConstant.PRINT_SECOND_RANK;
import static lotto.view.output.constant.OutputFormatConstant.PRINT_THIRD_RANK;
import static lotto.view.output.constant.OutputMessageConstant.ANNOUNCE_LOTTO_RESULT_INTRO;
import static lotto.view.output.constant.OutputMessageConstant.ASK_TO_INSERT_BONUS_NUMBER;
import static lotto.view.output.constant.OutputMessageConstant.ASK_TO_INSERT_LOTTO_MONEY;
import static lotto.view.output.constant.OutputMessageConstant.ASK_TO_INSERT_WINNING_LOTTO_NUMBERS;
import static lotto.view.output.constant.OutputMessageConstant.SEPARATOR_BAR;
import static lotto.view.output.constant.OutputSymbolConstant.LOTTO_NUMBER_JOINING_DELIMITER;
import static lotto.view.output.constant.OutputSymbolConstant.LOTTO_NUMBER_OUTPUT_LEFT_BRACE;
import static lotto.view.output.constant.OutputSymbolConstant.LOTTO_NUMBER_OUTPUT_RIGHT_BRACE;
import static lotto.view.output.constant.OutputSymbolConstant.NEW_LINE;

import java.util.EnumMap;
import java.util.stream.Collectors;
import lotto.domain.LottoResult;
import lotto.dto.BoughtLottoNumbersDtos;
import lotto.dto.TotalResultDto;

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

    public void printTotalResult(TotalResultDto totalResultDto) {
        printLine();
        print(ANNOUNCE_LOTTO_RESULT_INTRO.getMessage());
        printLine();
        print(SEPARATOR_BAR.getMessage());
        printLottoResults(totalResultDto.lottoResults());
        print(String.format(PRINT_RATE_OF_RETURN_FORMAT.getFormat(), totalResultDto.rateOfReturn()));
        printLine();
    }

    private void printLottoResults(EnumMap<LottoResult, Integer> lottoResults) {
        printLine();
        print(String.format(PRINT_FIFTH_RANK.getFormat(), FIFTH_RANK.getPrizeMoney(),
                lottoResults.get(FIFTH_RANK)));
        printLine();
        print(String.format(PRINT_FOURTH_RANK.getFormat(), FOURTH_RANK.getPrizeMoney(),
                lottoResults.get(FOURTH_RANK)));
        printLine();
        print(String.format(PRINT_THIRD_RANK.getFormat(), THIRD_RANK.getPrizeMoney(), lottoResults.get(THIRD_RANK)));
        printLine();
        print(String.format(PRINT_SECOND_RANK.getFormat(), SECOND_RANK.getPrizeMoney(), lottoResults.get(SECOND_RANK)));
        printLine();
        print(String.format(PRINT_FIRST_RANK.getFormat(), FIRST_RANK.getPrizeMoney(), lottoResults.get(FIRST_RANK)));
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
