package racingcar.application.dto;

import racingcar.domain.Car;

public record CarView(
    String name,
    int position
) {
    public static CarView from(Car car) {
        return new CarView(car.getName(), car.getPosition());
    }
}
