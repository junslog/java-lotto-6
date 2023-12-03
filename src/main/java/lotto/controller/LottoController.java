package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.UserMoney;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.util.LottoFactory;
import lotto.dto.BoughtLottoNumbersDto;
import lotto.dto.BoughtLottoNumbersDtos;
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
        List<Integer> lottoNumbers = new ArrayList<>();
        generatedLotto.getNumbers().stream()
                .sorted()
                .forEach(lottoNumber -> lottoNumbers.add(lottoNumber.getNumber()));
        return new BoughtLottoNumbersDto(lottoNumbers);
    }

    private WinningLottoNumbers getWinningLottoNumbers() {
        return readUserInput(() -> {
            outputView.askToInsertWinningLottoNumbers();
            return new WinningLottoNumbers(inputView.getWinningLottoNumbers());
        });
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
