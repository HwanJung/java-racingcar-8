package racingcar;

import racingcar.application.CarRacingRunner;
import racingcar.controller.RacingCarController;
import racingcar.parser.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarRacingRunner carRacingRunner = new CarRacingRunner(outputView);
        Parser parser = new Parser();
        RacingCarController racingCarController = new RacingCarController(inputView, parser, carRacingRunner);

        racingCarController.run();
    }
}
