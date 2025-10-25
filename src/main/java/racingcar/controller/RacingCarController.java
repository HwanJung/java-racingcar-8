package racingcar.controller;

import racingcar.application.CarRaceRunner;
import racingcar.application.dto.RaceResult;
import racingcar.ui.input.Parser;
import racingcar.ui.input.InputView;
import racingcar.ui.output.OutputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Parser parser;
    private final CarRaceRunner carRaceRunner;

    public RacingCarController(InputView inputView, OutputView outputView, Parser parser, CarRaceRunner carRaceRunner) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
        this.carRaceRunner = carRaceRunner;
    }

    public void run() throws IllegalArgumentException {
        String carNamesStr = inputView.readCarNames();
        String attemptNumberStr = inputView.readAttemptNumber();

        List<String> carNames = parser.parseCarNames(carNamesStr);
        int attemptNumber = parser.parseAttemptNumber(attemptNumberStr);

        outputView.printStart();
        RaceResult raceResult = carRaceRunner.run(carNames, attemptNumber);
        outputView.printRoundsResult(raceResult.roundsResult());
        outputView.printEnd(raceResult.winningCars());
    }
}
