package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_LENGTH;
import static lotto.domain.exception.DomainConstraintExceptionMessage.LOTTO_LENGTH_IS_NOT_APPROPRIATE;
import static lotto.domain.exception.DomainConstraintExceptionMessage.LOTTO_NUMBER_IS_DUPLICATED;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.domain.exception.DomainConstraintException;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = parseToLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateIsSizeLessThanLimit(numbers);
        validateIsNotDuplicated(numbers);
    }

    private void validateIsSizeLessThanLimit(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw DomainConstraintException.of(LOTTO_LENGTH_IS_NOT_APPROPRIATE.getMessage());
        }
    }

    private void validateIsNotDuplicated(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw DomainConstraintException.of(LOTTO_NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return new HashSet<>(numbers)
                .size() < numbers.size();
    }

    private List<LottoNumber> parseToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}