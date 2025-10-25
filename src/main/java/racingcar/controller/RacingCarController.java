package racingcar.controller;

import racingcar.application.CarRacingRunner;
import racingcar.ui.input.Parser;
import racingcar.ui.input.InputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final Parser parser;
    private final CarRacingRunner carRacingRunner;

    public RacingCarController(InputView inputView, Parser parser, CarRacingRunner carRacingRunner) {
        this.inputView = inputView;
        this.parser = parser;
        this.carRacingRunner = carRacingRunner;
    }

    public void run() throws IllegalArgumentException {
        String carNamesStr = inputView.readCarNames();
        String attemptNumberStr = inputView.readAttemptNumber();

        List<String> carNames = parser.parseCarNames(carNamesStr);
        int attemptNumber = parser.parseAttemptNumber(attemptNumberStr);

        carRacingRunner.run(carNames, attemptNumber);
    }
}
