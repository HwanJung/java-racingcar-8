package racingcar.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: car name is null or empty");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("Invalid input: car name must be less than 5 characters");
        }

        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        this.position++;
    }

    @Override
    public String toString() {
        return this.name +
            " : " +
            "-".repeat(this.position);
    }
}
