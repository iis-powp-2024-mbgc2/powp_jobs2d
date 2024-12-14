package edu.kis.powp.jobs2d.features;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.line.AbstractLine;
import edu.kis.powp.appbase.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LineFeature {

    private static Color color = Color.CYAN;
    private static float thickness = 3.0f;
    private static boolean dotted = true;

    public static ILine getLine() {
        return new CustomLine(color, thickness, dotted);
    }

    public static void setupAdvancedLinePlugin(Application application) {
        application.addComponentMenu(LineFeature.class, "Line configuration");
        application.addComponentMenuElement(LineFeature.class, "Change color", LineFeature::colorChangeHandler);
        application.addComponentMenuElement(LineFeature.class, "Change thickness", LineFeature::thicknessChangeHandler);
        application.addComponentMenuElementWithCheckBox(LineFeature.class, "Toggle dotted", LineFeature::dottedToggleHandler, true);
    }


    private static void colorChangeHandler(ActionEvent actionEvent) {
        Color newColor = JColorChooser.showDialog(null, "Select new color", color);
        if (newColor != null) {
            color = newColor;
        }
    }

    private static void thicknessChangeHandler(ActionEvent actionEvent) {
        String value = JOptionPane.showInputDialog(null, "Please provide new thickness value", thickness);
        try {
            int number = Integer.parseInt(value);
            if (number < 0) {
                JOptionPane.showMessageDialog(null, "Thickness cannot be less than zero!", "Value error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            thickness = number;
        } catch (NumberFormatException _) {
            JOptionPane.showMessageDialog(null, "Thickness value must be a number!", "Value error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void dottedToggleHandler(ActionEvent actionEvent) {
        dotted = !dotted;
    }

    /**
     * This class has only one purpose – expose initialization of line parameters.
     */
    private static class CustomLine extends AbstractLine {
        public CustomLine(Color color, float thickness, boolean dotted) {
            this.color = color;
            this.thickness = thickness;
            this.dotted = dotted;
        }
    }
}
