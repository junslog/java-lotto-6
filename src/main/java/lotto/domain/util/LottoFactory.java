package lotto.domain.util;

import static lotto.domain.LottoConstants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.LongStream;
import lotto.domain.Lotto;
import lotto.domain.UserMoney;

public class LottoFactory {
    public static List<Lotto> generateAutoLottosByMoney(UserMoney userMoney) {
        long count = userMoney.getUserMoney() / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        LongStream.range(0L, count).forEach(
                i -> lottos.add(generateOneAutoLotto())
        );
        return Collections.unmodifiableList(lottos);
    }

    private static Lotto generateOneAutoLotto() {
        return new Lotto(generateLottoNumbers());
    }

    private static List<Integer> generateLottoNumbers() {
        return LottoNumberGenerator.generateLottoNumbers();
    }
}