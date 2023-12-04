package lotto.view.input.constant;

public enum InputSymbolConstant {
    WINNING_LOTTO_NUMBER_DELIMITER(","),
    BLANK(" "),
    VOID("");

    private final String symbol;

    InputSymbolConstant(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}