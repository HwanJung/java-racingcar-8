package racingcar.application;

import racingcar.domain.Car;
import racingcar.view.OutputView;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingRunner {
    private final OutputView outputView;

    public CarRacingRunner(OutputView outputView) {
        this.outputView = outputView;
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
            int randomNumber = Randoms.pickNumberInRange(0, 9);

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


