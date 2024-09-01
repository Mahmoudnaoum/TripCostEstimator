package org.example;

public class TripCostModel {

    public double calculateTotalCost(double distance, double gasolineCost, double gasMileage,
                                     double hotelCost, double foodCost, int numberOfDays, double attractionsCost,
                                     boolean isKilometers, boolean isLiters, boolean isKPL) {

        if (isKilometers) {
            distance = distance * 0.621371;
        }
        if (isLiters) {
            gasolineCost = gasolineCost * 3.78541;
        }
        if (isKPL) {
            gasMileage = gasMileage * 2.35215;
        }

        double totalGasolineCost = (distance / gasMileage) * gasolineCost;

        return totalGasolineCost + (hotelCost + foodCost) * numberOfDays + attractionsCost;
    }
}
