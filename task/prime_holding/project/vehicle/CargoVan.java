package prime_holding.project.vehicle;

public class CargoVan extends Vehicle {
    private int driversExperience;
    public CargoVan(VehicleType vehicleType, String brand, int value, int driversExperience) {
        super(vehicleType, brand, value);
        this.driversExperience = driversExperience;
    }

    public int getDriversExperience() {
        return driversExperience;
    }
}
