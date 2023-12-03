package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_LENGTH;
import static lotto.domain.exception.DomainConstraintExceptionMessage.LOTTO_LENGTH_IS_NOT_APPROPRIATE;

import java.util.Collections;
import java.util.List;
import lotto.domain.exception.DomainConstraintException;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = parseToLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw DomainConstraintException.of(LOTTO_LENGTH_IS_NOT_APPROPRIATE.getMessage());
        }
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