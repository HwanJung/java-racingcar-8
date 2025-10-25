package racingcar.application;

import racingcar.domain.Car;
import racingcar.application.random.NumberPicker;
import racingcar.ui.output.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingRunner {
    private final OutputView outputView;
    private final NumberPicker numberPicker;

    public CarRacingRunner(OutputView outputView, NumberPicker numberPicker) {
        this.outputView = outputView;
        this.numberPicker = numberPicker;
    }

    public void run(List<String> carNames, int attemptNumber) {
        List<Car> cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());

        outputView.printStart();
        for (int i = 0; i < attemptNumber; i++) {
            playRound(cars);
            outputView.printRoundResult(cars);
        }

        List<Car> winnerList = createWinnerList(cars);
        outputView.printEnd(winnerList);
    }

    private void playRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = numberPicker.pick(0, 9);

            if (randomNumber > 3) {
                car.move();
            }
        }
    }

    private List<Car> createWinnerList(List<Car> cars) {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        return cars.stream()
            .filter(c -> c.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }
}


