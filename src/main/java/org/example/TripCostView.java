package org.example;

import javax.swing.*;
import java.awt.*;

public class TripCostView {
    private JPanel mainPanel;
    private JTextField distanceField, gasolineField, mileageField, daysField, hotelField, foodField, attractionsField, resultField;
    private JComboBox<String> distanceUnit, gasolineUnit, mileageUnit;
    private JButton calculateButton;

    public TripCostView() {
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Set padding
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        int textFieldWidth = 20;

        JLabel distanceLabel = new JLabel("Distance:");
        distanceField = new JTextField(textFieldWidth);
        distanceUnit = new JComboBox<>(new String[]{"Miles", "Kilometers"});

        JLabel gasolineLabel = new JLabel("Gasoline Cost:");
        gasolineField = new JTextField(textFieldWidth);
        gasolineUnit = new JComboBox<>(new String[]{"Dollars/Gallon", "Dollars/Liter"});

        JLabel mileageLabel = new JLabel("Gas Mileage:");
        mileageField = new JTextField(textFieldWidth);
        mileageUnit = new JComboBox<>(new String[]{"Miles/Gallon", "Kilos/Gallon"});

        JLabel daysLabel = new JLabel("Number of Days:");
        daysField = new JTextField(textFieldWidth);

        JLabel hotelLabel = new JLabel("Hotel Cost:");
        hotelField = new JTextField(textFieldWidth);

        JLabel foodLabel = new JLabel("Food Cost:");
        foodField = new JTextField(textFieldWidth);

        JLabel attractionsLabel = new JLabel("Attractions:");
        attractionsField = new JTextField(textFieldWidth);

        calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Total Cost:");
        resultField = new JTextField(textFieldWidth);
        resultField.setEditable(false);

        addComponentsToPanel(gbc, distanceLabel, distanceField, distanceUnit, 0);
        addComponentsToPanel(gbc, gasolineLabel, gasolineField, gasolineUnit, 1);
        addComponentsToPanel(gbc, mileageLabel, mileageField, mileageUnit, 2);
        addComponentsToPanel(gbc, daysLabel, daysField, null, 3);
        addComponentsToPanel(gbc, hotelLabel, hotelField, null, 4);
        addComponentsToPanel(gbc, foodLabel, foodField, null, 5);
        addComponentsToPanel(gbc, attractionsLabel, attractionsField, null, 6);

        // Calculate button and result
        gbc.gridx =0; gbc.gridy = 7; gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(calculateButton, gbc);
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 1;
        mainPanel.add(resultLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(resultField, gbc);
    }

    private void addComponentsToPanel(GridBagConstraints gbc, JLabel label, JTextField textField, JComboBox<String> comboBox, int row) {
        gbc.gridx = 0; gbc.gridy = row;
        gbc.gridwidth = 1;
        mainPanel.add(label, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        mainPanel.add(textField, gbc);
        if (comboBox != null) {
            gbc.gridx = 2;
            mainPanel.add(comboBox, gbc);
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public JTextField getDistanceField() {
        return distanceField;
    }

    public JTextField getGasolineField() {
        return gasolineField;
    }

    public JTextField getMileageField() {
        return mileageField;
    }

    public JTextField getDaysField() {
        return daysField;
    }

    public JTextField getHotelField() {
        return hotelField;
    }

    public JTextField getFoodField() {
        return foodField;
    }

    public JTextField getAttractionsField() {
        return attractionsField;
    }

    public JTextField getResultField() {
        return resultField;
    }

    public JComboBox<String> getDistanceUnit() {
        return distanceUnit;
    }

    public JComboBox<String> getGasolineUnit() {
        return gasolineUnit;
    }

    public JComboBox<String> getMileageUnit() {
        return mileageUnit;
    }
}
