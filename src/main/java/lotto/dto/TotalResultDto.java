package lotto.dto;

import java.util.EnumMap;
import lotto.domain.LottoResult;

public record TotalResultDto(EnumMap<LottoResult, Integer> lottoResults, double rateOfReturn) {
}
