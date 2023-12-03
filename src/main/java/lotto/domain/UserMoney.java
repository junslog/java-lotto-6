package lotto.domain;

import static lotto.domain.exception.DomainConstraintExceptionMessage.USER_MONEY_NOT_DIVIDED_WITH_LOTTO_MONEY;

import lotto.domain.exception.DomainConstraintException;

public class UserMoney {
    private static final int LOTTO_PRICE = 1000;

    private final long userMoney;

    public UserMoney(final long userMoney) {
        validateIsDividedWithLottoMoney(userMoney);
        this.userMoney = userMoney;
    }

    private void validateIsDividedWithLottoMoney(final long userMoney) {
        if (userMoney % LOTTO_PRICE != 0) {
            throw DomainConstraintException.of(USER_MONEY_NOT_DIVIDED_WITH_LOTTO_MONEY.getMessage());
        }
    }
}