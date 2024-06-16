package prime_holding.project.calculator;

import prime_holding.project.vehicle.Car;
import prime_holding.project.vehicle.CargoVan;
import prime_holding.project.vehicle.Motorcycle;
import prime_holding.project.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.Period;

public class RentCalculator {
    private final static int WEEK = 7;
    private final static int CAR_RENTAL_COST_UNDER_WEEK = 20;
    private final static int CAR_RENTAL_COST_OVER_WEEK = 15;
    private final static int CARGO_VAN_RENTAL_COST_UNDER_WEEK = 50;
    private final static int CARGO_VAN_RENTAL_COST_OVER_WEEK = 40;
    private final static int MOTORCYCLE_RENTAL_COST_UNDER_WEEK = 15;
    private final static int MOTORCYCLE_RENTAL_COST_OVER_WEEK = 10;
    private final static double CAR_INSURANCE_PERCENTAGE = 0.001;
    private final static double CARGO_VAN_INSURANCE_PERCENTAGE = 0.003;
    private final static double MOTORCYCLE_INSURANCE_PERCENTAGE = 0.002;
    private final static int HALF = 2;
    private final static int GOOD_SAFETY_RATING = 4;
    private final static double CAR_DISCOUNT = 0.9;
    private final static int BAD_RIDERS_AGE = 25;
    private final static double MOTORCYCLE_MARKUP = 1.2;
    private final static int GOOD_DRIVERS_EXPERIENCE  = 5;
    private final static double CARGO_VAN_DISCOUNT = 0.85;

    private static double getRentalCostForVehicle(Vehicle vehicle, long duration) {
        if(duration <= WEEK ) {
             return switch (vehicle.getVehicleType()) {
                case CAR -> CAR_RENTAL_COST_UNDER_WEEK;
                case CARGO_VAN -> CARGO_VAN_RENTAL_COST_UNDER_WEEK;
                case MOTORCYCLE -> MOTORCYCLE_RENTAL_COST_UNDER_WEEK;
             };

        }
        return switch (vehicle.getVehicleType()) {
            case CAR -> CAR_RENTAL_COST_OVER_WEEK;
            case CARGO_VAN -> CARGO_VAN_RENTAL_COST_OVER_WEEK;
            case MOTORCYCLE -> MOTORCYCLE_RENTAL_COST_OVER_WEEK;
        };
    }
    private static double calculateRentalCost(Vehicle vehicle, LocalDate startDate, LocalDate  endDate, LocalDate returnDate) {
        Period durationBetweenStartAndEndDate = Period.between(startDate, endDate);
        Period durationBetweenEndDateAndReturnDate = Period.between(returnDate, endDate);
        double rentalCostForTheVehicle = getRentalCostForVehicle(vehicle, durationBetweenStartAndEndDate.getDays());
        if (durationBetweenEndDateAndReturnDate.getDays() == 0) {
            return rentalCostForTheVehicle * durationBetweenStartAndEndDate.getDays();
        }
        return rentalCostForTheVehicle * (durationBetweenStartAndEndDate.getDays() - durationBetweenEndDateAndReturnDate.getDays())
            + (rentalCostForTheVehicle / HALF) * durationBetweenEndDateAndReturnDate.getDays();
    }

    private static double getInsuranceCost(Vehicle vehicle) {
        return switch (vehicle.getVehicleType()) {
            case CAR -> CAR_INSURANCE_PERCENTAGE;
            case CARGO_VAN -> CARGO_VAN_INSURANCE_PERCENTAGE;
            case MOTORCYCLE -> MOTORCYCLE_INSURANCE_PERCENTAGE;
        };
    }
    private static double calculateInsuranceCost(Vehicle vehicle, LocalDate startDate, LocalDate endDate,
                                                 LocalDate returnDate) {
        Period durationBetweenStartAndEndDate = Period.between(startDate, endDate);
        Period durationBetweenEndDateAndReturnDate = Period.between(returnDate, endDate);
        double insuranceCost = getInsuranceCost(vehicle) * vehicle.getValue();
        if (vehicle instanceof Car car && car.getSafetyRating() >= GOOD_SAFETY_RATING) {
            insuranceCost = insuranceCost * CAR_DISCOUNT;
        }
        if (vehicle instanceof  Motorcycle motorcycle && motorcycle.getRidersAge() < BAD_RIDERS_AGE) {
            insuranceCost = insuranceCost * MOTORCYCLE_MARKUP;
        }
        if (vehicle instanceof CargoVan cargoVan && cargoVan.getDriversExperience() > GOOD_DRIVERS_EXPERIENCE) {
            insuranceCost = insuranceCost * CARGO_VAN_DISCOUNT;
        }
        if(durationBetweenEndDateAndReturnDate.getDays() == 0) {
            return insuranceCost * durationBetweenStartAndEndDate.getDays();
        }
        return insuranceCost * (durationBetweenStartAndEndDate.getDays() - durationBetweenEndDateAndReturnDate.getDays());
    }

    public static double calculateRent(Vehicle vehicle, LocalDate  startDate, LocalDate  endDate, LocalDate returnDate) {
        double rentalCost = calculateRentalCost(vehicle, startDate, endDate,returnDate);
        double insuranceCost = calculateInsuranceCost(vehicle, startDate, endDate,returnDate);
        return rentalCost + insuranceCost;
    }
}
