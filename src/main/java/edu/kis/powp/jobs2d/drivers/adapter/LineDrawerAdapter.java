package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.function.Supplier;

public class LineDrawerAdapter implements Job2dDriver {

    private int startX = 0, startY = 0;
    private final DrawPanelController drawPanelController;

    private final Supplier<ILine> lineSupplier;
    public LineDrawerAdapter(DrawPanelController drawPanelController, Supplier<ILine> lineSupplier) {
        this.drawPanelController = drawPanelController;
        this.lineSupplier = lineSupplier;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = this.lineSupplier.get();
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        drawPanelController.drawLine(line);
        setPosition(x,y);
    }

    @Override
    public String toString() {
        return "Line Drawer Adapter";
    }

}
