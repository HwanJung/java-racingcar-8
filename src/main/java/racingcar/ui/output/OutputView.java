package racingcar.ui.output;

import racingcar.application.dto.CarView;
import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printStart() {
        System.out.println("\n실행결과");
    }

    public void printRoundsResult(List<List<CarView>> roundsResult) {
        StringBuilder sb = new StringBuilder();

        for (List<CarView> cars : roundsResult) {
            for (CarView car : cars) {
                sb.append(formatCarLine(car)).append("\n");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public void printEnd(List<CarView> winners) {
        String winnersString = winners.stream()
            .map(CarView::name)
            .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnersString);
    }

    private String formatCarLine(CarView car) {
        return car.name() +
            " : " +
            "-".repeat(car.position());
    }
}
