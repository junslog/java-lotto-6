package lotto.domain;

import java.util.EnumMap;

public class LottoMachine {
    private final WinningLottoNumbers winningLottoNumbers;
    private final BonusNumber bonusNumber;

    public LottoMachine(WinningLottoNumbers winningLottoNumbers, BonusNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult calculateLottoResult(Lotto userLotto) {
        int matchNumber = 0;
        boolean bonusMatched = false;

        for (LottoNumber lottoNumber : userLotto.getNumbers()) {
            if (winningLottoNumbers.includesNumber(lottoNumber)) {
                matchNumber++;
            }
            if (lottoNumber.equals(bonusNumber.getBonusNumber())) {
                bonusMatched = true;
            }
        }

        return LottoResult.create(matchNumber, bonusMatched);
    }

    public double calculateRateOfReturn(EnumMap<LottoResult, Integer> lottoResults, final long userMoney) {
        long earnedMoney = 0L;
        for (LottoResult lottoResult : lottoResults.keySet()) {
            int winNumber = lottoResults.get(lottoResult);
            earnedMoney += winNumber * lottoResult.getPrizeMoney();
        }
        return Math.round((((double) earnedMoney / userMoney * 10) / 10.0) * 100);
    }
}