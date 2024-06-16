# Vehicle-Rental-System

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Enums and Abstract Class  
VehicleType enum defines types of vehicles.  
Vehicle abstract class includes common attributes and a constructor.  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Concrete Vehicle Classes  
Motorcycle, CargoVan, and Car classes extend Vehicle, adding specific attributes and validation in their constructors.  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
RentCalculator Class  
Constants: Define various cost rates and thresholds.  
Rental Cost Calculation: getRentalCostForVehicle determines the daily rental rate based on the vehicle type and rental duration. calculateRentalCost computes the total rental cost   considering the rental period and any late returns.  
Insurance Cost Calculation: getInsuranceCost provides the insurance rate based on vehicle type. calculateInsuranceCost adjusts the insurance cost based on specific vehicle attributes and late returns.  
Total Cost Calculation: calculateRent combines the rental and insurance costs to provide the total cost for the rental period.  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
