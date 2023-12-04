package lotto.view.output.constant;

public enum OutputSymbolConstant {
    NEW_LINE(System.lineSeparator()),
    LOTTO_NUMBER_OUTPUT_LEFT_BRACE("["),
    LOTTO_NUMBER_OUTPUT_RIGHT_BRACE("]"),
    LOTTO_NUMBER_JOINING_DELIMITER(", ");

    private final String symbol;

    OutputSymbolConstant(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}