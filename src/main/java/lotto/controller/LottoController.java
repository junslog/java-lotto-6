package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.UserMoney;
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
    }

    private UserMoney getUserMoney() {
        return readUserInput(() -> {
            outputView.askToInsertMoney();
            return new UserMoney(inputView.getUserMoney());
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
