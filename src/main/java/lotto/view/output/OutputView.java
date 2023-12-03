package lotto.view.output;

import static lotto.view.output.constant.OutputMessageConstant.ASK_TO_INSERT_LOTTO_MONEY;
import static lotto.view.output.constant.OutputSymbolConstant.NEW_LINE;

public class OutputView {

    public void askToInsertMoney() {
        print(ASK_TO_INSERT_LOTTO_MONEY.getMessage());
        printLine();
    }

    public void printError(String message) {
        print(message);
        printLine();
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void printLine() {
        print(NEW_LINE.getSymbol());
    }
}
