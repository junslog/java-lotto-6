package lotto.domain;

import static lotto.domain.exception.DomainConstraintExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.Objects;
import lotto.domain.exception.DomainConstraintException;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(final int number) {
        validateIsInAppropriateRange(number);
        this.number = number;
    }

    private void validateIsInAppropriateRange(final int number) {
        if (!isInAppropriateRange(number)) {
            throw DomainConstraintException.of(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isInAppropriateRange(final int number) {
        return number >= LottoConstants.LOTTO_MIN_NUMBER
                && number <= LottoConstants.LOTTO_MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return number - lottoNumber.number;
    }

    public int getNumber() {
        return number;
    }
}