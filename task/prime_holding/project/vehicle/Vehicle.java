package prime_holding.project.vehicle;

abstract public class Vehicle {
    private VehicleType vehicleType;
    private String brand;
    private double value;
    public Vehicle(VehicleType vehicleType, String brand, double value) {
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.value = value;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public double getValue() {
        return value;
    }
}
