package edu.kis.powp.jobs2d.customLines;

import edu.kis.legacy.drawer.shape.line.BasicLine;

import java.awt.Color;

public class CustomizableLine extends BasicLine {
    public CustomizableLine() {
        super();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public void setIsDotted(boolean isDoted) {
        this.dotted = isDoted;
    }
}
