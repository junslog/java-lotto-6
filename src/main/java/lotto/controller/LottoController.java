package lotto.controller;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.UserMoney;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.util.LottoFactory;
import lotto.dto.BoughtLottoNumbersDto;
import lotto.dto.BoughtLottoNumbersDtos;
import lotto.dto.TotalResultDto;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {
        UserMoney userMoney = getUserMoney();
        List<Lotto> generatedLottos = LottoFactory.generateAutoLottosByMoney(userMoney);
        printUserLottos(generatedLottos);

        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningLottoNumbers);
        LottoMachine lottoMachine = new LottoMachine(winningLottoNumbers, bonusNumber);
        printTotalResult(lottoMachine, generatedLottos, userMoney);
    }

    private UserMoney getUserMoney() {
        return readUserInput(() -> {
            outputView.askToInsertMoney();
            return new UserMoney(inputView.getUserMoney());
        });
    }

    private void printUserLottos(List<Lotto> generatedLottos) {
        List<BoughtLottoNumbersDto> boughtLottoNumbersDtos = new ArrayList<>();
        generatedLottos.forEach(
                generatedLotto -> boughtLottoNumbersDtos.add(getUserLottoPringUnit(generatedLotto))
        );
        outputView.printUserLottos(new BoughtLottoNumbersDtos(boughtLottoNumbersDtos, boughtLottoNumbersDtos.size()));
    }

    private BoughtLottoNumbersDto getUserLottoPringUnit(Lotto generatedLotto) {
        List<Integer> lottoNumbers = generatedLotto.getNumbers().stream()
                .sorted()
                .mapToInt(LottoNumber::getNumber)
                .boxed()
                .toList();
        return new BoughtLottoNumbersDto(lottoNumbers);
    }

    private WinningLottoNumbers getWinningLottoNumbers() {
        return readUserInput(() -> {
            outputView.askToInsertWinningLottoNumbers();
            return new WinningLottoNumbers(inputView.getWinningLottoNumbers());
        });
    }

    private BonusNumber getBonusNumber(WinningLottoNumbers winningLottoNumbers) {
        return readUserInput(() -> {
            outputView.askToInsertBonusNumber();
            return new BonusNumber(inputView.getBonusNumber(), winningLottoNumbers);
        });
    }

    private void printTotalResult(LottoMachine lottoMachine, List<Lotto> generatedLottos, UserMoney userMoney) {
        EnumMap<LottoResult, Integer> lottoResults = LottoResult.provideEmptyResultMap();
        generatedLottos.forEach(
                generatedLotto -> {
                    LottoResult lottoResult = lottoMachine.calculateLottoResult(generatedLotto);
                    lottoResults.put(lottoResult, lottoResults.get(lottoResult) + 1);
                });
        double rateOfReturn = lottoMachine.calculateRateOfReturn(lottoResults, userMoney.getUserMoney());
        outputView.printTotalResult(new TotalResultDto(lottoResults, rateOfReturn));
    }

    private <T> T readUserInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
