package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TripCostModelTest {

    @Test
    public void testCalculateTotalCost_MilesDollarsMPG() {
        TripCostModel model = new TripCostModel();

        double distance = 500; // miles
        double gasolineCost = 3.50; // dollars/gallon
        double gasMileage = 25; // miles/gallon
        double hotelCost = 100; // dollars per night
        double foodCost = 50; // dollars per day
        int numberOfDays = 2;
        double attractionsCost = 150; // dollars

        // Expected: Gasoline cost + hotel & food cost + attractions cost
        // Gasoline cost: (500 miles / 25 mpg) * $3.50 = $70
        // Total cost: $70 + ($100 + $50) * 2 days + $150 = $520
        double expectedTotalCost = 520.0;

        double actualTotalCost = model.calculateTotalCost(distance, gasolineCost, gasMileage, hotelCost, foodCost, numberOfDays, attractionsCost, false, false, false);

        assertEquals(expectedTotalCost, actualTotalCost, 0.01);
    }

    @Test
    public void testCalculateTotalCost_KilometersLitersKPL() {
        TripCostModel model = new TripCostModel();

        double distance = 800.0; // kilometers
        double gasolineCost = 1.20; // dollars/liter
        double gasMileage = 10; // kilometers/liter
        double hotelCost = 100; // dollars per night
        double foodCost = 50; // dollars per day
        int numberOfDays = 2;
        double attractionsCost = 150.0; // dollars

        // Conversions:
        // 800 km to miles: 800 * 0.621371 = 497.1 miles
        // 1.20 dollars/liter to dollars/gallon: 1.20 * 3.78541 = 4.54 dollars/gallon
        // 10 kilometers/liter to miles/gallon: 10 * 2.35215 = 23.52 miles/gallon

        // Gasoline cost: (497.1 miles / 23.52 mpg) * $4.54 = ~$95.89
        // Total cost: $95.89 + ($100 + $50) * 2 days + $150 = ~$545.89
        double expectedTotalCost = 546;

        double actualTotalCost = model.calculateTotalCost(distance, gasolineCost, gasMileage, hotelCost, foodCost, numberOfDays, attractionsCost, true, true, true);

        assertEquals(expectedTotalCost, actualTotalCost, 0.01);
    }

    @Test
    public void testCalculateTotalCost_ZeroDistance() {
        TripCostModel model = new TripCostModel();

        double distance = 0; // miles
        double gasolineCost = 3.50; // dollars/gallon
        double gasMileage = 25; // miles/gallon
        double hotelCost = 100; // dollars per night
        double foodCost = 50; // dollars per day
        int numberOfDays = 2;
        double attractionsCost = 150; // dollars

        // Zero distance means zero gasoline cost
        // Total cost: $0 + ($100 + $50) * 2 days + $150 = $500
        double expectedTotalCost = 450.0;

        double actualTotalCost = model.calculateTotalCost(distance, gasolineCost, gasMileage, hotelCost, foodCost, numberOfDays, attractionsCost, false, false, false);

        assertEquals(expectedTotalCost, actualTotalCost, 0.01);
    }

}
