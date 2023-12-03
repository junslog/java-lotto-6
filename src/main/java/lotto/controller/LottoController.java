package lotto.controller;

import java.util.function.Supplier;
import lotto.view.input.InputView;
import lotto.view.input.exception.InputException;
import lotto.view.output.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {

    }


    private <T> T readUserInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (InputException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
