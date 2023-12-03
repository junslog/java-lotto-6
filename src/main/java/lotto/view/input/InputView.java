package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.input.parser.InputParser;

public class InputView {
    private final InputParser inputParser;

    public InputView() {
        this.inputParser = new InputParser();
    }

    public String readLine() {
        return Console.readLine();
    }
}