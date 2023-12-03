package lotto.view.output.constant;

public enum OutputMessageConstant {
    ASK_TO_INSERT_LOTTO_MONEY("구입금액을 입력해주세요."),
    ASK_TO_INSERT_WINNING_LOTTO_NUMBERS("당첨 번호를 입력해 주세요.");
    private final String message;

    OutputMessageConstant(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}