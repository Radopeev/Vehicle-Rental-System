package prime_holding.project.vehicle;

public class Motorcycle extends Vehicle{
    private static int MIN_AGE = 0;
    private static int MAX_AGE = 100;
    private int ridersAge;
    public Motorcycle(VehicleType vehicleType, String brand, int value, int ridersAge) {
        super(vehicleType, brand, value);
        if(ridersAge < MIN_AGE || ridersAge > MAX_AGE) {
            throw new IllegalArgumentException("Rider age must be between 0 and 100");
        }
        this.ridersAge = ridersAge;
    }

    public int getRidersAge() {
        return ridersAge;
    }
}
