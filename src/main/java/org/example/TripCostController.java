package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TripCostController {

    private TripCostModel model;
    private TripCostView view;

    public TripCostController(TripCostModel model, TripCostView view) {
        this.model = model;
        this.view = view;

        view.getCalculateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double distance = Double.parseDouble(view.getDistanceField().getText());
                    double gasolineCost = Double.parseDouble(view.getGasolineField().getText());
                    double gasMileage = Double.parseDouble(view.getMileageField().getText());
                    double hotelCost = Double.parseDouble(view.getHotelField().getText());
                    double foodCost = Double.parseDouble(view.getFoodField().getText());
                    int numberOfDays = Integer.parseInt(view.getDaysField().getText());
                    double attractionsCost = Double.parseDouble(view.getAttractionsField().getText());

                    // if unit conversions
                    boolean isKilometers = view.getDistanceUnit().getSelectedItem().equals("Kilometers");
                    boolean isLiters = view.getGasolineUnit().getSelectedItem().equals("Dollars/Liter");
                    boolean isKPL = view.getMileageUnit().getSelectedItem().equals("Kilos/Gallon");

                    // Calculate total trip cost
                    double totalTripCost = model.calculateTotalCost(distance, gasolineCost, gasMileage, hotelCost, foodCost, numberOfDays, attractionsCost, isKilometers, isLiters, isKPL);

                    // Display the result
                    view.getResultField().setText(String.format("$%.2f", totalTripCost));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view.getMainPanel(), "Please enter valid numeric values.");
                }
            }
        });
    }
}
