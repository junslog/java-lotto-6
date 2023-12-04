package lotto.view.output.constant;

public enum OutputFormatConstant {
    PRINT_NUMBER_OF_LOTTOS_BOUGHT_FORMAT("%d개를 구매했습니다."),
    PRINT_FIFTH_RANK("3개 일치 (%,d원) - %d개"),
    PRINT_FOURTH_RANK("4개 일치 (%,d원) - %d개"),
    PRINT_THIRD_RANK("5개 일치 (%,d원) - %d개"),
    PRINT_SECOND_RANK("5개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    PRINT_FIRST_RANK("6개 일치 (%,d원) - %d개"),
    PRINT_RATE_OF_RETURN_FORMAT("총 수익률은 %.1f%%입니다.");

    private final String format;

    OutputFormatConstant(final String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}