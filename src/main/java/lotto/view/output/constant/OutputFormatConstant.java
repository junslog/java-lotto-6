package lotto.view.output.constant;

public enum OutputFormatConstant {
    PRINT_NUMBER_OF_LOTTOS_BOUGHT_FORMAT("%d개를 구매했습니다.");

    private final String format;

    OutputFormatConstant(final String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}