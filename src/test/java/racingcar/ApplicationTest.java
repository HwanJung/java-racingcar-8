package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("우승자가 1명인 경우")
    void run_whenValidInput_thenPrintResult2() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "2");
                assertThat(output()).contains("pobi : --", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("우승자가 2명인 경우")
    void run_whenValidInput_thenPrintResult3() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "2");
                assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("아무도 안움직인 경우")
    void run_whenValidInput_thenPrintResult4() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "2");
                assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
            },
            STOP, STOP, STOP, STOP
        );
    }

    @Test
    @DisplayName("5글자를 초과한 이름이 존재하면 예외")
    void run_whenInvalidInput_thenThrowsException1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력에 비어있는 이름이 있다면 예외")
    void run_whenInvalidInput_thenThrowsException2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력에 비어있는 이름이 있다면 예외")
    void run_whenInvalidInput_thenThrowsException3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 0이하이면 예외")
    void run_whenInvalidInput_thenThrowsException4() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
