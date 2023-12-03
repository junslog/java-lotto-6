package lotto.domain.util;

import static lotto.domain.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoConstants.LOTTO_MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
    public static int generateLottoNumber() {
        return Randoms.pickNumberInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
    }
}