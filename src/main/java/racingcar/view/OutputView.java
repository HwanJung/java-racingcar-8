package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printStart() {
        System.out.println("실행결과");
    }

    public void printRoundResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(formatCarLine(car)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public void printEnd(List<Car> winners) {
        String winnersString = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnersString );
    }

    private String formatCarLine(Car car) {
        return car.getName() +
                " : " +
                "-".repeat(car.getPosition());

    }
}
