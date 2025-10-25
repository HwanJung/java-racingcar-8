package racingcar.ui.input;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    private final Parser parser = new Parser();

    @Test
    void parseCarNames_whenNameIsEmpty_thenThrowsException1() {
        // given
        String input = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseCarNames(input));
    }

    @Test
    void parseCarNames_whenNameIsNull_thenThrowsException2() {
        // given
        String input = "car,,name";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseCarNames(input));
    }

    @Test
    void parseCarNames_whenNameIsWhitespace_thenThrowsException1() {
        // given
        String input = " ";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseCarNames(input));
    }

    @Test
    void parseCarNames_whenNameIsWhitespace_thenThrowsException2() {
        // given
        String input = "car, , name";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseCarNames(input));
    }

    @Test
    void parseCarNames_whenValidInput_thenReturnCarNames() {
        // given
        String input = "car1, car2,car3";
        List<String> expectedCarNames = Arrays.asList("car1", "car2", "car3");

        // when
        List<String> carNames = parser.parseCarNames(input);

        // then
        assertThat(expectedCarNames).containsExactlyElementsOf(expectedCarNames);
    }

    @Test
    void parseAttemptNumber_whenInputIsEmpty_thenThrowsException() {
        // given
        String input = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseAttemptNumber(input));
    }

    @Test
    void parseAttemptNumber_whenInputIsNotNumber_thenThrowsException() {
        // given
        String input = "noNumber";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseAttemptNumber(input));
    }

    @Test
    void parseAttemptNumber_whenInputIsNegative_thenThrowsException() {
        // given
        String input = "-1";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseAttemptNumber(input));
    }

    @Test
    void parseAttemptNumber_whenInputIsZero_thenThrowsException() {
        // given
        String input = "0";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseAttemptNumber(input));
    }

    @Test
    void parseAttemptNumber_whenValidInput_thenReturnNumber() {
        // given
        String input = "4";

        // when
        int result = parser.parseAttemptNumber(input);

        // then
        assertThat(result).isEqualTo(4);
    }
}
