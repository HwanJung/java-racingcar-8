package racingcar;

import racingcar.application.CarRaceRunner;
import racingcar.controller.RacingCarController;
import racingcar.ui.input.Parser;
import racingcar.application.random.NumberPicker;
import racingcar.infra.random.RandomNumberPicker;
import racingcar.ui.input.InputView;
import racingcar.ui.output.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberPicker numberPicker = new RandomNumberPicker();
        CarRaceRunner carRaceRunner = new CarRaceRunner(numberPicker);
        Parser parser = new Parser();
        RacingCarController racingCarController = new RacingCarController(inputView, outputView, parser, carRaceRunner);

        racingCarController.run();
    }
}
