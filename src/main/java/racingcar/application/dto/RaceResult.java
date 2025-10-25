package racingcar.application.dto;

import java.util.List;

public record RaceResult (
    List<List<CarView>> roundsResult,
    List<CarView> winningCars
){
}
