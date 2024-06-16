import prime_holding.project.vehicle.Car;
import prime_holding.project.vehicle.CargoVan;
import prime_holding.project.vehicle.Motorcycle;
import prime_holding.project.calculator.RentCalculator;
import prime_holding.project.vehicle.VehicleType;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car car = new Car(VehicleType.CAR, "Mistubishi Mirage",15000,3);
        double totalCostOne = RentCalculator.calculateRent(car, LocalDate.of(2024,6,3),
            LocalDate.of(2024,6,13),LocalDate.of(2024,6,13));
        System.out.println(totalCostOne);

        Motorcycle motorcycle = new Motorcycle(VehicleType.MOTORCYCLE,"Triumph Tiger Sport 660",10000,20);
        double totalCostTwo = RentCalculator.calculateRent(motorcycle, LocalDate.of(2024,6,3),
            LocalDate.of(2024,6,13),LocalDate.of(2024,6,13));
        System.out.println(totalCostTwo);

        CargoVan cargoVan = new CargoVan(VehicleType.CARGO_VAN, "Citroen Jumper", 20000, 8);
        double totalCostThree = RentCalculator.calculateRent(cargoVan, LocalDate.of(2024,6,3),
            LocalDate.of(2024,6,18),LocalDate.of(2024,6,13));
        System.out.println(totalCostThree);
    }
}