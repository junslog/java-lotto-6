package lotto.domain;

import java.util.List;

public class WinningLottoNumbers {
    private List<LottoNumber> winningLottoNumbers;

    public WinningLottoNumbers(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = parseToLottoNumbers(winningLottoNumbers);
    }

    private List<LottoNumber> parseToLottoNumbers(List<Integer> winningLottoNumbers) {
        return winningLottoNumbers.stream()
                .map(LottoNumber::new)
                .toList();
    }
}