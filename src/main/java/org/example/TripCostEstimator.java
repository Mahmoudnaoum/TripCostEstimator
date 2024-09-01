package org.example;

import javax.swing.*;

public class TripCostEstimator {

    public static void main(String[] args) {
        // Initialize the Model, View, and Controller
        TripCostModel model = new TripCostModel();
        TripCostView view = new TripCostView();
        TripCostController controller = new TripCostController(model, view);

        // Set up the frame
        JFrame frame = new JFrame("Trip Cost Estimator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.add(view.getMainPanel());
        frame.setVisible(true);
    }
}
