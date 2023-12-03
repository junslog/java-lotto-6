package lotto.domain.exception;

import static lotto.global.Constants.ERROR_PREFIX;

public enum DomainConstraintExceptionMessage {
    USER_MONEY_NOT_DIVIDED_WITH_LOTTO_MONEY("로또 금액이 1000원으로 나누어 떨어지지 않습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1~45 사이의 숫자여야 합니다."),
    LOTTO_LENGTH_IS_NOT_APPROPRIATE("로또는 6개의 숫자로 이루어져 있어야 합니다."),
    BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_LOTTO_NUMBERS("보너스 번호와 당첨 번호가 중복됩니다.");

    private final String message;

    DomainConstraintExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}