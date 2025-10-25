package racingcar.infra.random;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.application.random.NumberPicker;

public class RandomNumberPicker implements NumberPicker {
    @Override
    public int pick(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
