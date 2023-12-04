package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.input.parser.InputParser;

public class InputView {
    private final InputParser inputParser;

    public InputView() {
        this.inputParser = new InputParser();
    }

    public long getUserMoney() {
        return inputParser.parseToUserMoney(readLine());
    }

    public List<Integer> getWinningLottoNumbers() {
        return inputParser.parseToWinningLottoNumbers(readLine());
    }

    public int getBonusNumber() {
        return inputParser.parseToBonusNumber(readLine());
    }

    public String readLine() {
        return Console.readLine();
    }

}