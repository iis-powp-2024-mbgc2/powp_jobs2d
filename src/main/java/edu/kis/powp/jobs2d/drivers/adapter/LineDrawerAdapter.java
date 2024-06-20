package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.LineType;
import edu.kis.powp.jobs2d.features.DrawerFeature;

import static edu.kis.legacy.drawer.shape.LineFactory.*;

public class LineDrawerAdapter implements Job2dDriver {
    private int startX = 0, startY = 0;
    private final LineType lineType;

    public LineDrawerAdapter(LineType lineType) {
        super();
        this.lineType = lineType;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = createLine(lineType);

        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        DrawerFeature.getDrawerController().drawLine(line);
        setPosition(x, y);
    }

    private ILine createLine(LineType lineType) {
        switch (lineType) {
            case SPECIAL:
                return getSpecialLine();
            case DOTTED:
                return getDottedLine();
            case BASIC:
            default:
                return getBasicLine();
        }
    }

    @Override
    public String toString() {
        return "Line drawer adapter";
    }
}
