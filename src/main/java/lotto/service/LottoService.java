package lotto.service;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.UserMoney;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.constant.LottoConstant;

public class LottoService {
    public UserMoney initUserMoney(final long userMoney) {
        return UserMoney.from(userMoney);
    }

    public long calculateNumberOfLottos(UserMoney userMoney) {
        return userMoney.getUserMoney() / LottoConstant.LOTTO_PRICE.getValue();
    }

    public WinningLottoNumbers initWinningLottoNumbers(final List<Integer> winningLottoNumbers) {
        return WinningLottoNumbers.from(new Lotto(winningLottoNumbers));
    }

    public BonusNumber initBonusNumber(final WinningLottoNumbers winningLottoNumbers, final int bonusNumber) {
        return BonusNumber.of(bonusNumber, winningLottoNumbers.getWinningLottoNumbers());
    }
}