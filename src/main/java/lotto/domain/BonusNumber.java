package lotto.domain;

import static lotto.domain.exception.DomainConstraintExceptionMessage.BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_LOTTO_NUMBERS;

import lotto.domain.exception.DomainConstraintException;

public class BonusNumber {
    private final LottoNumber bonusNumber;

    public BonusNumber(final int lottoNumber, WinningLottoNumbers winningLottoNumbers) {
        bonusNumber = parseToLottoNumber(lottoNumber);
        validate(lottoNumber, winningLottoNumbers);
    }

    private void validate(int lottoNumber, WinningLottoNumbers winningLottoNumbers) {
        if (winningLottoNumbers.includesNumber(lottoNumber)) {
            throw DomainConstraintException.of(BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_LOTTO_NUMBERS.getMessage());
        }
    }

    private LottoNumber parseToLottoNumber(final int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }
}