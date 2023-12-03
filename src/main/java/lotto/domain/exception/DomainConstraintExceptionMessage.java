package lotto.domain.exception;

import static lotto.global.Constants.ERROR_PREFIX;

public enum DomainConstraintExceptionMessage {
    USER_MONEY_NOT_DIVIDED_WITH_LOTTO_MONEY("로또 금액이 1000원으로 나누어 떨어지지 않습니다.");

    private final String message;

    DomainConstraintExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}