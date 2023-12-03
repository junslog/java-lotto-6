package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController racingCarController = new LottoController(new InputView(), new OutputView());
        racingCarController.execute();
        Console.close();
    }
}
