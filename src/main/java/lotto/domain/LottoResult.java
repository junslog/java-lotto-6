package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;

public enum LottoResult {
    NONE(0, 0, false),
    FIFTH_RANK(5_000, 3, false),
    FOURTH_RANK(50_000, 4, false),
    THIRD_RANK(1_500_000, 5, false),
    SECOND_RANK(30_000_000, 5, true),
    FIRST_RANK(2_000_000_000, 6, false);

    private final long prizeMoney;
    private final int matchNumber;
    private final boolean bonusMatched;

    LottoResult(final long prizeMoney, final int matchNumber, final boolean bonusMatched) {
        this.prizeMoney = prizeMoney;
        this.matchNumber = matchNumber;
        this.bonusMatched = bonusMatched;
    }

    public static LottoResult create(int matchNumber, boolean bonusMatched) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.matchNumber == matchNumber
                        && lottoResult.bonusMatched == bonusMatched)
                .findAny()
                .orElse(NONE);
    }

    public static EnumMap<LottoResult, Integer> provideEmptyResultMap() {
        EnumMap<LottoResult, Integer> emptyResultMap = new EnumMap<>(LottoResult.class);
        Arrays.stream(LottoResult.values())
                .forEach(lottoResult -> {
                            emptyResultMap.put(lottoResult, 0);
                        }
                );
        return emptyResultMap;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}