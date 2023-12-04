package lotto.domain;

import java.util.EnumMap;

public class LottoMachine {
    private static final int rateOfReturnScaleDecimalPoint = 3;
    private static final double rateOfReturnScale = Math.pow(10, rateOfReturnScaleDecimalPoint);
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
        return convertToPercentage(toGivenScale((double) earnedMoney / userMoney, rateOfReturnScale));
    }

    private double toGivenScale(double value, double decimalPointScale) {
        return Math.round(value * decimalPointScale) / decimalPointScale;
    }

    private double convertToPercentage(double valueWithGivenScale) {
        return valueWithGivenScale * 100;
    }
}