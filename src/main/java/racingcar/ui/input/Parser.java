package racingcar.ui.input;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<String> parseCarNames(String carNames) {
        List<String> cars = new ArrayList<>();
        String[] nameArray = carNames.split(",", -1);
        for (String name : nameArray) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid input: car name cannot be empty");
            }
            cars.add(name.trim());
        }

        return cars;
    }

    public int parseAttemptNumber(String attemptNumber) {
        if (attemptNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input: attempt number cannot be empty");
        }

        int result;

        try {
            result = Integer.parseInt(attemptNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: attempt number must be an integer");
        }

        if (result < 1) {
            throw new IllegalArgumentException("Invalid input: attempt number must be a positive integer");
        }

        return result;
    }
}
