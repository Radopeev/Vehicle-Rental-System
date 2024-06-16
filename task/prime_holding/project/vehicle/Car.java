package prime_holding.project.vehicle;

public class Car extends Vehicle {
    private static int MIN_SAFETY_RATING = 1;
    private static int MAX_SAFETY_RATING = 5;
    private int safetyRating;
    public Car(VehicleType vehicleType, String brand, double value, int safetyRating) {
        super(vehicleType, brand, value);
        if(safetyRating < MIN_SAFETY_RATING || safetyRating > MAX_SAFETY_RATING) {
            throw new IllegalArgumentException("Safety Rating must be between 1 and 5");
        }
        this.safetyRating = safetyRating;
    }

    public int getSafetyRating() {
        return safetyRating;
    }
}
