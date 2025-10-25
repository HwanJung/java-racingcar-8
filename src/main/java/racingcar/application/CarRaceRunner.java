package racingcar.application;

import racingcar.application.dto.CarView;
import racingcar.application.dto.RaceResult;
import racingcar.domain.Car;
import racingcar.application.random.NumberPicker;

import java.util.ArrayList;
import java.util.List;

public class CarRaceRunner {
    private static final int RANGE_MIN = 0;
    private static final int RANGE_MAX = 9;
    private static final int MOVE_THRESHOLD = 3;

    private final NumberPicker numberPicker;

    public CarRaceRunner(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public RaceResult run(List<String> carNames, int attemptNumber) {
        List<Car> cars = makeCarList(carNames);

        List<List<CarView>> roundsResult = new ArrayList<>();
        for (int i = 0; i < attemptNumber; i++) {
            playRound(cars);
            List<CarView> roundResult = cars.stream()
                .map(CarView::from)
                .toList();
            roundsResult.add(roundResult);
        }

        List<CarView> winningCars = createWinningCars(cars);

        return new RaceResult(List.copyOf(roundsResult), List.copyOf(winningCars));
    }

    private List<Car> makeCarList(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .toList();
    }

    private void playRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = numberPicker.pick(RANGE_MIN, RANGE_MAX);

            if (randomNumber > MOVE_THRESHOLD) {
                car.move();
            }
        }
    }

    private List<CarView> createWinningCars(List<Car> cars) {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        return cars.stream()
            .filter(c -> c.getPosition() == maxPosition)
            .map(CarView::from)
            .toList();
    }
}


